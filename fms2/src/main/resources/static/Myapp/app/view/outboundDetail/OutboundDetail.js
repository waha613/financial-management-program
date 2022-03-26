var toolbarTop = Ext.create('Ext.toolbar.Toolbar', {
    dock: 'top',
    items: [
        {
            xtype:'combo',
            fieldLabel:'仓库',
            labelWidth:60,
            width:200,
            store: Ext.create('MyApp.store.Buyer'),
            displayField: 'warehouse',
            valueField: 'warehouse',
            queryMode: 'remote',
            reference:'warehouse',
        },
        '-',
        {
            xtype:'datefield',
            fieldLabel:'出库日期',
            labelWidth:60,
            width:200,
            format:'Y-m-d',
            reference:'outboundStartDate'
        },
        {
            xtype:'datefield',
            fieldLabel:'至',
            labelWidth:20,
            width:200,
            format:'Y-m-d',
            reference:'outboundEndDate'
        },
        '-',
        {
            xtype:'combo',
            fieldLabel:'产品编号',
            labelWidth:60,
            width:200,
            store: Ext.create('MyApp.store.MyProduct'),
            displayField: 'productID',
            valueField: 'productID',
            queryMode: 'remote',
            reference:'productID',
        },
        '-',
        {
            xtype:'button',
            text:'查询',
            listeners: {
                click: 'getOutboundDetails'
            }
        },
        '-',
        {
            xtype: 'button',
            text: '统计',
            listeners: {
                click: 'getAllOutboundDetailStatistics'
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
            xtype:'button',
            text:'新增',
            listeners: {
                click: 'addOutboundDetail'
            }
        },
        '-',
        {
            xtype:'button',
            text:'编辑',
            listeners: {
                click: 'updateOutboundDetail'
            }
        },
        '-',
        {
            xtype:'button',
            text:'删除',
            listeners: {
                click: 'deleteOutboundDetail'
            }
        },
    ]
});
Ext.define('MyApp.view.outboundDetail.OutboundDetail', {
    extend: 'Ext.grid.Panel',
    xtype: 'OutboundDetail',
    alias: 'view.OutboundDetail',
    controller:'OutboundDetail',
    reference:'OutboundDetail',
    viewConfig : {enableTextSelection:true},

    requires: [
        'MyApp.store.OutboundDetail',
        'MyApp.store.Buyer',
        'MyApp.view.outboundDetail.OutboundDetailController',
    ],

    title: '出库明细',

    store: {
        type: 'OutboundDetail'
    },
    selModel: {
        selType: 'checkboxmodel'
    },
    columns: [
        {text: '出库明细编号',dataIndex:'outboundId',hidden:true},
        {text: '仓库',dataIndex:'warehouse'},
        {text: '出库日期',dataIndex:'outboundDate'},
        {text: '出库产品编号',dataIndex:'productID'},
        {text: '物品单位',dataIndex:'unit'},
        {text: '单价(元/每斤)',dataIndex:'unitSalePrice'},
        {text: '出库数量',dataIndex:'outboundQuantity'},
        {text: '销售金额',dataIndex:'amountOfThisSale'},
        {text: '销售费用',dataIndex:'saleFee'},
        {text: '销售费用类型',dataIndex:'saleFeeType'},
        {text: '实际到账金额',dataIndex:'actualSales'},
        {text: '备注',dataIndex:'comment'},

    ],
    bbar:Ext.create('Ext.toolbar.Paging',
        {
            displayInfo: true,
            displayMsg: '第{0} 到 {1} 条数据 共{2}条',
            emptyMsg: '没有数据',
            store: this.store
        }),
    dockedItems: [toolbarTop, toolbarBottom],
    // listeners: {
    //     select: 'onItemSelected'
    // }
});

