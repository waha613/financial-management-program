Ext.define('MyApp.view.myProduct.MyProductController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.MyProduct',

    getProducts: function (btn, record) {

        this.getView().getStore().loadPage(1);
    },

    addProduct: function (btn, record) {
        var store = this.getView().getStore();
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../product/addProduct',

            // Fields will be arranged vertically, stretched to full width
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            frame: true,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: '产品编号',
                    allowBlank: false,
                    name: 'productID'
                },
                {
                    fieldLabel: '产品名称',
                    allowBlank: false,
                    name: 'productName'
                },
                {
                    fieldLabel: '产品规格',
                    allowBlank: false,
                    name: 'standard'
                },
                {
                    xtype:'numberfield',
                    fieldLabel: '子产品数量',
                    allowBlank: false,
                    name: 'itemQuantity'
                },
                {
                    xtype:'numberfield',
                    fieldLabel: '单个子产品重量',
                    allowBlank: false,
                    name: 'oneItemWeight'
                },
                {
                    xtype:'numberfield',
                    fieldLabel: '产品重量',
                    allowBlank: false,
                    name: 'oneProductWeight'
                },
                {
                    hidden:true,
                    fieldLabel: '重量单位',
                    allowBlank: false,
                    name: 'unit',
                    value:'斤',
                },
            ],
            buttons: [
                {
                    text: 'Submit',
                    handler: function () {
                        var form = this.up('form'); // get the form panel
                        if (form.isValid()) { // make sure the form contains valid data before submitting
                            form.submit({
                                success: function (form, action) {
                                    Ext.Msg.alert('Success', action.result.data);
                                    store.reload();
                                    createRecordFormWindow.close();
                                },
                                failure: function (form, action) {
                                    Ext.Msg.alert('Failed', action.result.data);
                                }
                            });
                        } else { // display error alert if the data is invalid
                            Ext.Msg.alert('Invalid Data', 'Please correct form errors.')
                        }
                    }
                }
            ]
        })
        var createRecordFormWindow = Ext.create('Ext.window.Window', {
            title: '新增产品信息',
            modal: true,
            items: [formPanel]
        });
        createRecordFormWindow.show();
    },

    // updateProduct: function (btn, record) {
    //     var store = this.getView().getStore();
    //     var selectedRecords = this.getView().getSelectionModel().getSelection();
    //     var sel = selectedRecords[0];
    //     var formPanel = Ext.create('Ext.form.Panel', {
    //         bodyPadding: 5,
    //         width: 350,
    //
    //         // The form will submit an AJAX request to this URL when submitted
    //         url: '../../product/updateProduct',
    //
    //         // Fields will be arranged vertically, stretched to full width
    //         layout: 'anchor',
    //         defaults: {
    //             anchor: '100%'
    //         },
    //         frame: true,
    //         defaultType: 'textfield',
    //         items: [
    //             {
    //                 fieldLabel: '产品编号',
    //                 allowBlank: false,
    //                 readOnly:true,
    //                 name: 'productID'
    //             },
    //             {
    //                 fieldLabel: '产品名称',
    //                 allowBlank: false,
    //                 name: 'productName'
    //             },
    //             {
    //                 fieldLabel: '产品规格',
    //                 allowBlank: false,
    //                 name: 'standard'
    //             },
    //             {
    //                 xtype:'numberfield',
    //                 fieldLabel: '子产品数量',
    //                 allowBlank: false,
    //                 name: 'itemQuantity'
    //             },
    //             {
    //                 xtype:'numberfield',
    //                 fieldLabel: '单个子产品重量',
    //                 allowBlank: false,
    //                 name: 'oneItemWeight'
    //             },
    //             {
    //                 xtype:'numberfield',
    //                 fieldLabel: '产品重量',
    //                 allowBlank: false,
    //                 name: 'oneProductWeight'
    //             },
    //             {
    //                 hidden:true,
    //                 fieldLabel: '重量单位',
    //                 allowBlank: false,
    //                 name: 'unit',
    //                 value:'斤',
    //             },
    //         ],
    //         buttons: [
    //             {
    //                 text: 'Submit',
    //                 handler: function () {
    //                     var form = this.up('form'); // get the form panel
    //                     if (form.isValid()) { // make sure the form contains valid data before submitting
    //                         form.submit({
    //                             success: function (form, action) {
    //                                 Ext.Msg.alert('Success', action.result.data);
    //                                 store.reload();
    //                                 updateRecordFormWindow.close();
    //                             },
    //                             failure: function (form, action) {
    //                                 Ext.Msg.alert('Failed', action.result.data);
    //                             }
    //                         });
    //                     } else { // display error alert if the data is invalid
    //                         Ext.Msg.alert('Invalid Data', 'Please correct form errors.')
    //                     }
    //                 }
    //             }
    //         ]
    //     })
    //     formPanel.loadRecord(sel);
    //     var updateRecordFormWindow = Ext.create('Ext.window.Window', {
    //         title: '修改产品信息',
    //         modal: true,
    //         items: [formPanel]
    //     });
    //     updateRecordFormWindow.show();
    //
    // },

    deleteProduct: function (btn, record) {
        var store = this.getView().getStore();
        var select = this.getView().getSelectionModel().getSelection();
        var sel = select[0];
        Ext.MessageBox.confirm('Delete Alert!', "你确定要删除吗？", function (btn) {
            if (btn == "yes") {
                Ext.Ajax.request({
                    url: '../../product/deleteProduct',
                    params: {
                        productID: sel.get('productID'),
                    },
                    success: function (response) {
                        var res = Ext.decode(response.responseText);
                        if (res.success) {
                            Ext.Msg.alert('Success', res.data);
                            store.reload();
                        } else {
                            Ext.Msg.alert('ERROR', res.data);
                        }
                    },
                    failure: function () {
                        Ext.Msg.alert('ERROR', '通讯失败!检查是否已经连接上互联网');
                    },
                });
            }
        });
    }
})