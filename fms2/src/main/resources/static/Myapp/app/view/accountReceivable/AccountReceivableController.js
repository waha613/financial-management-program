Ext.define('MyApp.view.accountReceivable.AccountReceivableController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.AccountReceivable',

    getAllAccountsReceivableStatistics:function(btn, record){
        var warehouse = this.lookupReference('warehouse').value;
        var startDate = this.lookupReference('receiveStartDate').value;
        var receiveEndDate = this.lookupReference('receiveEndDate').value;
        var receiveMethod = this.lookupReference('receiveMethod').value;

        var statisticsStore = Ext.create('Ext.data.Store',{
            model: 'MyApp.model.AccountReceivable',
            proxy: {
                type: 'ajax',
                api: {
                    read: '../../accountReceivable/getAllAccountsReceivableStatistics',
                },
                reader: {
                    type: 'json',
                    rootProperty: 'data',
                }
            },
            autoLoad: false,
        })
        statisticsStore.getProxy().setExtraParams({
            'warehouse': warehouse,
            'receiveStartDate': startDate,
            'receiveEndDate': receiveEndDate,
            'receiveMethod': receiveMethod,
        })
        this.getView().setStore(statisticsStore);
        statisticsStore.reload();
    },
    getAccountsReceivable: function (btn, record) {
        var warehouse = this.lookupReference('warehouse').value;
        var startDate = this.lookupReference('receiveStartDate').value;
        var receiveEndDate = this.lookupReference('receiveEndDate').value;
        var receiveMethod = this.lookupReference('receiveMethod').value;
        var store = Ext.create('MyApp.store.AccountReceivable');
        // if (buyers == null || buyers == '') {
        //     Ext.Msg.alert('ERROR', '请选择购货商');
        //     return false;
        // }
        store.getProxy().setExtraParams({
            'warehouse': warehouse,
            'receiveStartDate': startDate,
            'receiveEndDate': receiveEndDate,
            'receiveMethod': receiveMethod,
        })
        this.getView().setStore(store);
        store.loadPage(1);
    },

    addAccountReceivable: function (btn, record) {
        var store = this.getView().getStore();
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../accountReceivable/addAccountReceivable',

            // Fields will be arranged vertically, stretched to full width
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            frame: true,
            defaultType: 'textfield',
            items: [
                {
                    xtype:'combo',
                    fieldLabel:'付款方',
                    store: Ext.create('MyApp.store.Buyer', {
                        autoLoad:true
                    }),
                    displayField: 'warehouse',
                    valueField: 'warehouse',
                    queryMode: 'remote',
                    allowBlank:false,
                    name:'warehouse',
                },
                {
                    xtype: 'datefield',
                    fieldLabel: '收款日期',
                    // format: 'Y-m-d H:i:s',
                    format: 'Y-m-d',
                    allowBlank:false,
                    name: 'receiveDate',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '收款金额',
                    allowBlank : false,
                    name: 'actualSales',
                    // id:'actualPaymentOfAccountPayable'
                },
                {
                    xtype: 'combo',
                    fieldLabel: '收款方式',
                    labelWidth: 60,
                    width: 200,
                    store: Ext.create('MyApp.store.Supplier', {
                        data : [
                            {"name":"AL", "value":"Alabama"},
                            {"name":"AK", "value":"Alaska"},
                            {"name":"AZ", "value":"Arizona"}
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'receiveMethod',
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
            title: '新增收款记录',
            modal: true,
            items: [formPanel]
        });
        createRecordFormWindow.show();
    },

    updateAccountReceivable: function (btn, record) {
        var store = this.getView().getStore();
        var selectedRecords = this.getView().getSelectionModel().getSelection();
        var sel = selectedRecords[0];
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../accountReceivable/updateAccountReceivable',

            // Fields will be arranged vertically, stretched to full width
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            frame: true,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: '收款记录编号',
                    hidden: true,
                    name: 'receiveId'
                },
                {
                    xtype:'combo',
                    fieldLabel:'付款方',
                    store: Ext.create('MyApp.store.Buyer', {
                        autoLoad:true
                    }),
                    displayField: 'warehouse',
                    valueField: 'warehouse',
                    queryMode: 'remote',
                    allowBlank:false,
                    name:'warehouse',
                },
                {
                    xtype: 'datefield',
                    fieldLabel: '收款日期',
                    // format: 'Y-m-d H:i:s',
                    format: 'Y-m-d',
                    allowBlank:false,
                    name: 'receiveDate',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '收款金额',
                    allowBlank : false,
                    name: 'actualSales',
                    // id:'actualPaymentOfAccountPayable'
                },
                {
                    xtype: 'combo',
                    fieldLabel: '收款方式',
                    labelWidth: 60,
                    width: 200,
                    store: Ext.create('MyApp.store.Supplier', {
                        data : [
                            {"name":"AL", "value":"Alabama"},
                            {"name":"AK", "value":"Alaska"},
                            {"name":"AZ", "value":"Arizona"}
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'receiveMethod',
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
            title: '修改收款记录',
            modal: true,
            items: [formPanel]
        });
        updateRecordFormWindow.show();
    },

    deleteAccountReceivable: function (btn, record) {
        var store = this.getView().getStore();
        var select = this.getView().getSelectionModel().getSelection();
        var sel = select[0];
        Ext.MessageBox.confirm('Delete Alert!', "你确定要删除吗？", function (btn) {
            if (btn == "yes") {
                Ext.Ajax.request({
                    url: '../../accountReceivable/deleteAccountReceivable',
                    params: {
                        receiveId:sel.get('receiveId')
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
    getAllOutboundDetailStatistics:function (btn, record){
        var warehouse = this.lookupReference('warehouse').value;
        var startDate = this.lookupReference('receiveStartDate').value;
        var receiveEndDate = this.lookupReference('receiveEndDate').value;
        var statisticsStore = Ext.create('MyApp.store.ReceivableStatistics');
        statisticsStore.getProxy().setExtraParams({
            'warehouse': warehouse,
            'startDate': startDate,
            'receiveEndDate': receiveEndDate,
        })
        var gridPanel = Ext.create('MyApp.view.ReceivableStatistics', {
            viewConfig: {enableTextSelection: true},
            columns: [
                {text: '仓库', dataIndex: 'warehouse'},
                {text: '起始日期', dataIndex: 'startDate'},
                {text: '截止日期', dataIndex: 'endDate'},
                {text: '应收售货金额', dataIndex: 'actualSales'},
                {text: '实际收款金额', dataIndex: 'actualReceive'},
                {text: '余款', dataIndex: 'balance'},
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
            title: '应收款项汇总',
            height: 600,
            width: 1000,
            layout: 'fit',
            modal: true,
            items: gridPanel
        }).show();
    },

})