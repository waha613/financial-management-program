Ext.define('MyApp.view.inboundDetails.InboundDetailsController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.InboundDetails',

    getAllInboundDetailStatistics:function(btn, record){
        var supplier = this.lookupReference('supplier').value;
        var startDate = this.lookupReference('inboundStartDate').value;
        var inboundEndDate = this.lookupReference('inboundEndDate').value;
        var productID = this.lookupReference('productID').value;
        var warehouse = this.lookupReference('warehouse').value;
        var statisticsStore = Ext.create('Ext.data.Store',{
            model: 'MyApp.model.InboundDetails',
            proxy: {
                type: 'ajax',
                api: {
                    read: '../../inboundDetailStatistics/getAllInboundDetailStatistics',
                },
                reader: {
                    type: 'json',
                    rootProperty: 'data',
                }
            },
            autoLoad: false
        });
        statisticsStore.getProxy().setExtraParams({
            'supplier': supplier,
            'inboundStartDate': startDate,
            'inboundEndDate': inboundEndDate,
            'productID': productID,
            'warehouse': warehouse,
            'statistics':0
        });
        this.getView().setStore(statisticsStore);
        this.getView().getStore().reload();
    },
    getInboundDetails: function (btn, record) {
        var supplier = this.lookupReference('supplier').value;
        var startDate = this.lookupReference('inboundStartDate').value;
        var inboundEndDate = this.lookupReference('inboundEndDate').value;
        var productID = this.lookupReference('productID').value;
        var warehouse = this.lookupReference('warehouse').value;
        var store = Ext.create('MyApp.store.InboundDetails');
        // if (buyers == null || buyers == '') {
        //     Ext.Msg.alert('ERROR', '请选择购货商');
        //     return false;
        // }
        store.getProxy().setExtraParams({
            'supplier': supplier,
            'inboundStartDate': startDate,
            'inboundEndDate': inboundEndDate,
            'productID': productID,
            'warehouse': warehouse,
            'statistics':0,
        })
        this.getView().setStore(store);
        store.loadPage(1);
    },

    addInboundDetails: function (btn, record) {
        var store = this.getView().getStore();
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../inboundDetails/addInboundDetails',

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
                    fieldLabel:'供应商',
                    store: Ext.create('MyApp.store.Supplier', {
                        autoLoad:true
                    }),
                    displayField: 'supplierID',
                    valueField: 'supplierID',
                    queryMode: 'remote',
                    allowBlank:false,
                    name:'supplier',
                },
                {
                    xtype: 'datefield',
                    fieldLabel: '入库日期',
                    format: 'Y-m-d',
                    allowBlank:false,
                    name: 'inboundDate',
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
                    name: 'unitPrice',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '入库数量',
                    allowBlank:false,
                    name: 'inboundQuantity',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '采购费用',
                    name: 'purchaseFee',
                },
                {
                    xtype: 'combo',
                    fieldLabel: '采购费用类型',
                    store: Ext.create('Ext.data.Store', {
                        fields: ['name', 'value'],
                        data: [
                            {name: '运费', value: '运费'},
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'purchaseFeeType'
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
            title: '新增入库明细',
            modal: true,
            items: [formPanel]
        });
        createRecordFormWindow.show();
    },

    updateInboundDetails: function (btn, record) {
        var store = this.getView().getStore();
        var selectedRecords = this.getView().getSelectionModel().getSelection();
        var sel = selectedRecords[0];
        var formPanel = Ext.create('Ext.form.Panel', {
            bodyPadding: 5,
            width: 350,

            // The form will submit an AJAX request to this URL when submitted
            url: '../../inboundDetails/updateInboundDetails',

            // Fields will be arranged vertically, stretched to full width
            layout: 'anchor',
            defaults: {
                anchor: '100%'
            },
            frame: true,
            defaultType: 'textfield',
            items: [
                {
                    fieldLabel: '入库明细编号',
                    hidden: true,
                    name: 'inboundId'
                },
                {
                    xtype:'combo',
                    fieldLabel:'供应商',
                    store: Ext.create('MyApp.store.Supplier', {
                        autoLoad:true
                    }),
                    displayField: 'supplierID',
                    valueField: 'supplierID',
                    queryMode: 'remote',
                    allowBlank:false,
                    name:'supplier',
                },
                {
                    xtype: 'datefield',
                    fieldLabel: '入库日期',
                    format: 'Y-m-d',
                    allowBlank:false,
                    name: 'inboundDate',
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
                    name: 'unitPrice',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '入库数量',
                    allowBlank:false,
                    name: 'inboundQuantity',
                },
                {
                    xtype: 'numberfield',
                    fieldLabel: '采购费用',
                    name: 'purchaseFee',
                },
                {
                    xtype: 'combo',
                    fieldLabel: '采购费用类型',
                    store: Ext.create('Ext.data.Store', {
                        fields: ['name', 'value'],
                        data: [
                            {name: '运费', value: '运费'},
                        ]
                    }),
                    displayField: 'name',
                    valueField: 'value',
                    queryMode: 'local',
                    name: 'purchaseFeeType'
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
            title: '修改入库明细',
            modal: true,
            items: [formPanel]
        });
        updateRecordFormWindow.show();
    },

    deleteInboundDetails: function (btn, record) {
        var store = this.getView().getStore();
        var select = this.getView().getSelectionModel().getSelection();
        var sel = select[0];
        Ext.MessageBox.confirm('Delete Alert!', "你确定要删除吗？", function (btn) {
            if (btn == "yes") {
                Ext.Ajax.request({
                    url: '../../inboundDetails/deleteInboundDetails',
                    params: {
                        inboundId:sel.get('inboundId')
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

    getInboundsDetailFromExcel:function (btn, record){
        var select = this.getView().getSelectionModel().getSelection();
        if(select.length === 0){
            Ext.Msg.alert("ERROR","请选择至少一条入库明细");
            return;
        }
        for (var i = 0; i < select.length; i++) {
            var inboundDetail = select[i];
            window.open('/inboundDetails/generateInvoice' +
                '?inboundId=' + inboundDetail.get('inboundId') , '_blank');
        }

    }
})