Ext.define('MyApp.view.accountPayable.AccountPayableController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.AccountPayable',

    getAllAccountPayableStatistics: function (btn, record) {
        var supplier = this.lookupReference('supplier').value;
        var startDate = this.lookupReference('payStartDate').value;
        var payEndDate = this.lookupReference('payEndDate').value;
        var paymentMethod = this.lookupReference('paymentMethod').value;

        var statisticsStore = Ext.create('Ext.data.Store', {
            model: 'MyApp.model.AccountPayable',
            proxy: {
                type: 'ajax',
                api: {
                    read: '../../accountPayable/getAllAccountsPayableStatistics',
                },
                reader: {
                    type: 'json',
                    rootProperty: 'data',
                }
            },
            autoLoad: false,
        })
        statisticsStore.getProxy().setExtraParams({
            'supplier': supplier,
            'payStartDate': startDate,
            'payEndDate': payEndDate,
            'paymentMethod': paymentMethod,
        })
        this.getView().setStore(statisticsStore);
        this.getView().getStore().reload();
    },
    getAccountsPayable: function (btn, record) {
        var supplier = this.lookupReference('supplier').value;
        var startDate = this.lookupReference('payStartDate').value;
        var payEndDate = this.lookupReference('payEndDate').value;
        var paymentMethod = this.lookupReference('paymentMethod').value;
        var store = Ext.create('MyApp.store.AccountPayable');
        // if (buyers == null || buyers == '') {
        //     Ext.Msg.alert('ERROR', '请选择购货商');
        //     return false;
        // }
        store.getProxy().setExtraParams({
            'supplier': supplier,
            'payStartDate': startDate,
            'payEndDate': payEndDate,
            'paymentMethod': paymentMethod,
        })
        this.getView().setStore(store);
        store.loadPage(1);
    },

    addAccountPayable: function (btn, record) {
        var store = this.getView().getStore();
        var selectedRecords = this.getView().getSelectionModel().getSelection();
        var sel = selectedRecords[0];
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../accountPayable/addAccountPayable',

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
                    fieldLabel: '收款方',
                    store: Ext.create('MyApp.store.Supplier', {
                        autoLoad: true
                    }),
                    displayField: 'supplierID',
                    valueField: 'supplierID',
                    queryMode: 'remote',
                    allowBlank: false,
                    name: 'supplier',
                },
                {
                    xtype: 'datefield',
                    fieldLabel: '付款日期',
                    // format: 'Y-m-d H:i:s',
                    format: 'Y-m-d',
                    allowBlank: false,
                    name: 'payDate',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '支付金额',
                    allowBlank: false,
                    name: 'amountOfThisPurchase',
                    // id:'amountOfThisPurchaseOfAccountPayable'
                },
                {
                    xtype: 'combo',
                    fieldLabel: '付款方式',
                    labelWidth: 60,
                    width: 200,
                    store: Ext.create('MyApp.store.Supplier', {
                        data: [
                            {"name": "AL", "value": "Alabama"},
                            {"name": "AK", "value": "Alaska"},
                            {"name": "AZ", "value": "Arizona"}
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'paymentMethod',
                },
                {
                    xtype: 'textfield',
                    fieldLabel: '备注',
                    name: 'comment'
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
            title: '新增付款记录',
            modal: true,
            items: [formPanel]
        });
        createRecordFormWindow.show();
    },

    updateAccountPayable: function (btn, record) {
        var store = this.getView().getStore();
        var selectedRecords = this.getView().getSelectionModel().getSelection();
        var sel = selectedRecords[0];
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../accountPayable/updateAccountPayable',

            // Fields will be arranged vertically, stretched to full width
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            frame: true,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: '付款记录编号',
                    hidden: true,
                    name: 'payID'
                },
                {
                    xtype: 'combo',
                    fieldLabel: '收款方',
                    store: Ext.create('MyApp.store.Supplier', {
                        autoLoad: true
                    }),
                    displayField: 'supplierID',
                    valueField: 'supplierID',
                    queryMode: 'remote',
                    allowBlank: false,
                    name: 'supplier',
                },
                {
                    xtype: 'datefield',
                    fieldLabel: '付款日期',
                    format: 'Y-m-d',
                    allowBlank: false,
                    name: 'payDate',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '支付金额',
                    allowBlank: false,
                    name: 'amountOfThisPurchase',
                    // id:'amountOfThisPurchaseOfAccountPayable'
                },
                {
                    xtype: 'combo',
                    fieldLabel: '付款方式',
                    labelWidth: 60,
                    width: 200,
                    store: Ext.create('MyApp.store.Supplier', {
                        data: [
                            {"name": "AL", "value": "Alabama"},
                            {"name": "AK", "value": "Alaska"},
                            {"name": "AZ", "value": "Arizona"}
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'paymentMethod',
                },
                {
                    xtype: 'textfield',
                    fieldLabel: '备注',
                    name: 'comment'
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
                                    updateRecordFormWindow.close();
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
        var updateRecordFormWindow = Ext.create('Ext.window.Window', {
            title: '修改付款记录',
            modal: true,
            items: [formPanel]
        });
        updateRecordFormWindow.show();
    },

    deleteAccountPayable: function (btn, record) {
        var store = this.getView().getStore();
        var select = this.getView().getSelectionModel().getSelection();
        var sel = select[0];
        Ext.MessageBox.confirm('Delete Alert!', "你确定要删除吗？", function (btn) {
            if (btn == "yes") {
                Ext.Ajax.request({
                    url: '../../accountPayable/deleteAccountPayable',
                    params: {
                        payID: sel.get('payID')
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
    },

    getPayableStatistics: function (btn, record) {
        var supplier = this.lookupReference('supplier').value;
        var startDate = this.lookupReference('payStartDate').value;
        var payEndDate = this.lookupReference('payEndDate').value;
        var statisticsStore = Ext.create('MyApp.store.PayableStatistics');
        statisticsStore.getProxy().setExtraParams({
            'supplier': supplier,
            'startDate': startDate,
            'endDate': payEndDate,
        })
        var gridPanel = Ext.create('MyApp.view.PayableStatistics', {
            viewConfig: {enableTextSelection: true},
            columns: [
                {text: '供应商', dataIndex: 'supplier'},
                {text: '起始日期', dataIndex: 'startDate'},
                {text: '截止日期', dataIndex: 'endDate'},
                {text: '应付购货金额', dataIndex: 'purchaseAmount'},
                {text: '实际支付金额', dataIndex: 'actualPayment'},
                {text: '未支付余款', dataIndex: 'balance'},

            ],
            bbar: Ext.create('Ext.toolbar.Paging',
                {
                    displayInfo: true,
                    displayMsg: '第{0} 到 {1} 条数据 共{2}条',
                    emptyMsg: '没有数据',
                    store: this.store,
                }),
            store: statisticsStore,
            forceFit:true,
        });
        Ext.create('Ext.window.Window', {
            title: '应付款项汇总',
            height: 600,
            width: 1000,
            layout: 'fit',
            modal: true,
            items: gridPanel
        }).show();
    }
})