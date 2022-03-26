var toolbarTop = Ext.create('Ext.toolbar.Toolbar', {
    dock: 'top',
    items: [
        {
            xtype: 'combo',
            fieldLabel: '供应商',
            labelWidth: 60,
            width: 200,
            store: Ext.create('MyApp.store.Supplier'),
            displayField: 'supplierID',
            valueField: 'supplierID',
            queryMode: 'remote',
            reference: 'supplier',
        },
        '-',
        {
            xtype: 'datefield',
            fieldLabel: '入库日期',
            labelWidth: 60,
            width: 200,
            format: 'Y-m-d',
            reference: 'inboundStartDate'
        },
        {
            xtype: 'datefield',
            fieldLabel: '至',
            labelWidth: 20,
            width: 200,
            format: 'Y-m-d',
            reference: 'inboundEndDate'
        },
        '-',
        {
            xtype: 'combo',
            fieldLabel: '产品编号',
            labelWidth: 60,
            width: 200,
            store: Ext.create('MyApp.store.MyProduct'),
            displayField: 'productID',
            valueField: 'productID',
            queryMode: 'remote',
            reference: 'productID',
        },
        '-',
        {
            xtype: 'combo',
            fieldLabel: '仓库',
            labelWidth: 60,
            width: 200,
            store: Ext.create('MyApp.store.Buyer'),
            displayField: 'warehouse',
            valueField: 'warehouse',
            queryMode: 'remote',
            reference: 'warehouse',
        },
        '-',
        {
            xtype: 'button',
            text: '查询',
            listeners: {
                click: 'getInboundDetails'
            }
        },
        '-',
        {
            xtype: 'button',
            text: '统计',
            listeners: {
                click: 'getAllInboundDetailStatistics'
            }
        },
    ]
});

var toolbarBottom = Ext.create('Ext.toolbar.Toolbar', {
    style: {
        borderTopWidth: '0px !important',
        borderBottomWidth: '1px !important'
    },
    items: [
        {
            xtype: 'button',
            text: '新增',
            listeners: {
                click: 'addInboundDetails'
            }
        },
        '-',
        {
            xtype: 'button',
            text: '编辑',
            listeners: {
                click: 'updateInboundDetails'
            }
        },
        '-',
        {
            xtype: 'button',
            text: '删除',
            listeners: {
                click: 'deleteInboundDetails'
            }
        },
        '-',
        {
            xtype: 'button',
            text: '生成入库单',
            listeners: {
                click: 'getInboundsDetailFromExcel'
            }
        },
    ]
});

Ext.define('MyApp.view.inboundDetails.InboundDetails', {
    extend: 'Ext.grid.Panel',
    xtype: 'InboundDetails',
    alias: 'view.InboundDetails',
    controller: 'InboundDetails',
    reference: 'InboundDetails',
    viewConfig: {enableTextSelection: true},

    requires: [
        'MyApp.store.InboundDetails',
        'MyApp.store.Buyer',
        'MyApp.view.inboundDetails.InboundDetailsController',
    ],

    title: '入库明细',

    store: {
        type: 'InboundDetails'
    },
    selModel: {
        selType: 'checkboxmodel'
    },

    columns: [
        {text: '入库明细编号', dataIndex: 'inboundId', hidden: true},
        {text: '供应商', dataIndex: 'supplier'},
        {text: '入库日期', dataIndex: 'inboundDate'},
        {text: '入库产品编号', dataIndex: 'productID'},
        {text: '物品单位', dataIndex: 'unit'},
        {text: '单价（元/每斤）', dataIndex: 'unitPrice'},
        {text: '入库数量', dataIndex: 'inboundQuantity'},
        {text: '货款金额', dataIndex: 'amountOfThisPurchase'},
        {text: '采购费用', dataIndex: 'purchaseFee'},
        {text: '采购费用类型', dataIndex: 'purchaseFeeType'},
        {text: '实际支出', dataIndex: 'actualPayment'},
        {text: '仓库', dataIndex: 'warehouse'},
        {text: '备注', dataIndex: 'comment'},

    ],
    bbar: Ext.create('Ext.toolbar.Paging',
        {
            displayInfo: true,
            displayMsg: '第{0} 到 {1} 条数据 共{2}条',
            emptyMsg: '没有数据',
            store: this.store
        }),

    dockedItems: [toolbarTop, toolbarBottom]
    // listeners: {
    //     select: 'onItemSelected'
    // }
});

