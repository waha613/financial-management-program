Ext.define('MyApp.view.buyer.BuyerController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Buyer',

    getBuyers: function (btn, record) {
        var buyerName = this.lookupReference('buyerName').value;

        if (buyerName == null || buyerName == '') {
            Ext.Msg.alert('ERROR', '请选择购货商');
            return false;
        }
        this.getView().getStore().getProxy().setExtraParams({
            'buyerName': buyerName,
        })
        this.getView().getStore().loadPage(1);
    },

    addBuyer: function (btn, record) {
        var store = this.getView().getStore();
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: 'buyer/addBuyer',

            // Fields will be arranged vertically, stretched to full width
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            frame: true,
            defaultType: 'textfield',
            items: [
                {
                    xtype: 'combo',
                    fieldLabel: '采购商',
                    store: Ext.create('MyApp.store.Buyer', {
                        proxy: {
                            type: 'ajax',
                            api: {
                                read: '../../buyer/getBuyerNameList',
                            },
                            reader: {
                                type: 'json',
                                rootProperty: 'data',
                            }
                        },
                    }),
                    displayField: 'buyerName',
                    valueField: 'buyerName',
                    queryMode: 'remote',
                    allowBlank: false,
                    name: 'buyerName',
                },
                {
                    fieldLabel: '仓库',
                    allowBlank: false,
                    name: 'warehouse'
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
            title: '新增采购商信息',
            modal: true,
            items: [formPanel]
        });
        createRecordFormWindow.show();
    },

    deleteBuyer: function (btn, record) {
        var store = this.getView().getStore();
        var select = this.getView().getSelectionModel().getSelection();
        var sel = select[0];
        Ext.MessageBox.confirm('Delete Alert!', "你确定要删除吗？", function (btn) {
            if (btn == "yes") {
                Ext.Ajax.request({
                    url: '../../buyer/deleteBuyer',
                    params: {
                        buyerName: sel.get('buyerName'),
                        warehouse: sel.get('warehouse')
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