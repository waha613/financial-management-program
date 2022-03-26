Ext.define('MyApp.view.supplier.SupplierController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Supplier',

    getSuppliers: function (btn, record) {
        this.getView().getStore().loadPage(1);
    },

    addSupplier: function (btn, record) {
        var store = this.getView().getStore();
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../supplier/addSupplier',

            // Fields will be arranged vertically, stretched to full width
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            frame: true,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: '供应商名称',
                    allowBlank: false,
                    name: 'supplierID'
                },
                {
                    fieldLabel: '供应商电话',
                    allowBlank: false,
                    name: 'phone'
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
            title: '新增供应商信息',
            modal: true,
            items: [formPanel]
        });
        createRecordFormWindow.show();
    },
    updateSupplier:function(btn,record){
        var store = this.getView().getStore();
        var selectedRecords = this.getView().getSelectionModel().getSelection();
        var sel = selectedRecords[0];var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../supplier/updateSupplier',

            // Fields will be arranged vertically, stretched to full width
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            frame: true,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: '供应商名称',
                    readOnly: true,
                    name: 'supplierID',

                },
                {
                    fieldLabel: '供应商电话',
                    allowBlank: false,
                    name: 'phone'
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
        formPanel.loadRecord(sel);
        var formWindow = Ext.create('Ext.window.Window', {
            title: '修改供应商信息',
            modal: true,
            items: [formPanel]
        });
        formWindow.show();

    },
    deleteSupplier: function (btn, record) {
        var store = this.getView().getStore();
        var select = this.getView().getSelectionModel().getSelection();
        var sel = select[0];
        Ext.MessageBox.confirm('Delete Alert!', "你确定要删除吗？", function (btn) {
            if (btn == "yes") {
                Ext.Ajax.request({
                    url: '../../supplier/deleteSupplier',
                    params: {
                        supplierID: sel.get('supplierID'),
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