Ext.define('MyApp.view.outboundDetail.OutboundDetailController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.OutboundDetail',
    getAllOutboundDetailStatistics:function (btn, record) {
        var startDate = this.lookupReference('outboundStartDate').value;
        var outboundEndDate = this.lookupReference('outboundEndDate').value;
        var productID = this.lookupReference('productID').value;
        var warehouse = this.lookupReference('warehouse').value;
        var statisticsStore = Ext.create('Ext.data.Store',{
            model: 'MyApp.model.OutboundDetail',
            proxy: {
                type: 'ajax',
                api: {
                    read: '../../outboundDetail/getAllOutboundDetailStatistics',
                },
                reader: {
                    type: 'json',
                    rootProperty: 'data',
                }
            },
            autoLoad: false,
        })
        statisticsStore.getProxy().setExtraParams({
            'outboundStartDate': startDate,
            'outboundEndDate': outboundEndDate,
            'productID': productID,
            'warehouse': warehouse,
        })
        this.getView().setStore(statisticsStore);
        statisticsStore.reload();
    },
    getOutboundDetails: function (btn, record) {
        var startDate = this.lookupReference('outboundStartDate').value;
        var outboundEndDate = this.lookupReference('outboundEndDate').value;
        var productID = this.lookupReference('productID').value;
        var warehouse = this.lookupReference('warehouse').value;
        // if (buyers == null || buyers == '') {
        //     Ext.Msg.alert('ERROR', '请选择购货商');
        //     return false;
        // }
        var store = Ext.create('MyApp.store.OutboundDetail');
        store.getProxy().setExtraParams({
            'outboundStartDate': startDate,
            'outboundEndDate': outboundEndDate,
            'productID': productID,
            'warehouse': warehouse,
        })
        this.getView().setStore(store);
        store.loadPage(1);
    },

    addOutboundDetail: function (btn, record) {
        var store = this.getView().getStore();
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../outboundDetail/addOutboundDetail',

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
                    fieldLabel:'仓库',
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
                    fieldLabel: '出库日期',
                    format: 'Y-m-d',
                    allowBlank:false,
                    name: 'outboundDate',
                },
                {
                    xtype:'combo',
                    fieldLabel:'产品编号',
                    store: Ext.create('MyApp.store.MyProduct', {
                        autoLoad:true
                    }),
                    displayField: 'productID',
                    valueField: 'productID',
                    queryMode: 'remote',
                    allowBlank:false,
                    name:'productID',
                    itemId:'productID',
                },
                {
                    xtype: 'combo',
                    fieldLabel: '物品单位',
                    store: Ext.create('Ext.data.Store', {
                        fields: ['name', 'value'],
                        data: [
                            {name: '捆', value: '捆'},
                            {name: '袋', value: '袋'},
                            {name: '箱', value: '箱'},
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'unit'
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '单价',
                    allowBlank:false,
                    defaultValue : 0,
                    name: 'unitSalePrice',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '出库数量',
                    allowBlank:false,
                    name: 'outboundQuantity',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '采购费用',
                    name: 'saleFee',
                },
                {
                    xtype: 'combo',
                    fieldLabel: '销售费用类型',
                    store: Ext.create('Ext.data.Store', {
                        fields: ['name', 'value'],
                        data: [
                            {name: '交仓费', value: '交仓费'},
                            {name: '残品存储费', value: '残品存储费'},
                            {name: '存存费', value: '存存费'},
                            {name: '操作退货费', value: '操作退货费'},
                            {name: '协同仓费', value: '协同仓费'},
                            {name: '运费', value: '运费'},
                            {name: '售后货款', value: '售后货款'},
                            {name: '缺货未出库', value: '缺货未出库'},
                            {name: '罚金', value: '罚金'},
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'saleFeeType'
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
            title: '新增出库明细',
            modal: true,
            items: [formPanel]
        });
        createRecordFormWindow.show();
    },

    updateOutboundDetail: function (btn, record) {
        var store = this.getView().getStore();
        var selectedRecords = this.getView().getSelectionModel().getSelection();
        var sel = selectedRecords[0];
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../outboundDetail/updateOutboundDetail',

            // Fields will be arranged vertically, stretched to full width
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            frame: true,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: '出库明细编号',
                    hidden: true,
                    name: 'outboundId'
                },
                {
                    xtype:'combo',
                    fieldLabel:'仓库',
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
                    fieldLabel: '出库日期',
                    format: 'Y-m-d',
                    allowBlank:false,
                    name: 'outboundDate',
                },
                {
                    xtype:'combo',
                    fieldLabel:'产品编号',
                    store: Ext.create('MyApp.store.MyProduct', {
                        autoLoad:true
                    }),
                    displayField: 'productID',
                    valueField: 'productID',
                    queryMode: 'remote',
                    allowBlank:false,
                    name:'productID',
                },
                {
                    xtype: 'combo',
                    fieldLabel: '物品单位',
                    store: Ext.create('Ext.data.Store', {
                        fields: ['name', 'value'],
                        data: [
                            {name: '捆', value: '捆'},
                            {name: '袋', value: '袋'},
                            {name: '箱', value: '箱'},
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'unit'
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '单价',
                    allowBlank:false,
                    defaultValue : 0,
                    name: 'unitSalePrice',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '出库数量',
                    allowBlank:false,
                    name: 'outboundQuantity',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '采购费用',
                    name: 'saleFee',
                },
                {
                    xtype: 'combo',
                    fieldLabel: '销售费用类型',
                    store: Ext.create('Ext.data.Store', {
                        fields: ['name', 'value'],
                        data: [
                            {name: '交仓费', value: '交仓费'},
                            {name: '残品存储费', value: '残品存储费'},
                            {name: '存存费', value: '存存费'},
                            {name: '操作退货费', value: '操作退货费'},
                            {name: '协同仓费', value: '协同仓费'},
                            {name: '运费', value: '运费'},
                            {name: '售后货款', value: '售后货款'},
                            {name: '缺货未出库', value: '缺货未出库'},
                            {name: '罚金', value: '罚金'},
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'saleFeeType'
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
            title: '修改出库明细',
            modal: true,
            items: [formPanel]
        });
        updateRecordFormWindow.show();
    },

    deleteOutboundDetail: function (btn, record) {
        var store = this.getView().getStore();
        var select = this.getView().getSelectionModel().getSelection();
        var sel = select[0];
        Ext.MessageBox.confirm('Delete Alert!', "你确定要删除吗？", function (btn) {
            if (btn == "yes") {
                Ext.Ajax.request({
                    url: '../../outboundDetail/deleteOutboundDetail',
                    params: {
                        outboundId:sel.get('outboundId')
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