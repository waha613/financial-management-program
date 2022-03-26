Ext.define('MyApp.view.buyer.Buyer', {
    extend: 'Ext.grid.Panel',
    xtype: 'Buyer',
    alias: 'view.Buyer',
    controller:'Buyer',
    closable:true,
    reference:'Buyer',
    viewConfig : {enableTextSelection:true},

    requires: [
        'MyApp.store.Buyer',
        'MyApp.view.buyer.BuyerController',
    ],

    title: '采购商信息',

    store: {
        type: 'Buyer'
    },

    columns: [
        {text: '购货商名称',dataIndex:'buyerName'},
        {text: '仓库',dataIndex:'warehouse'},
    ],

    bbar:Ext.create('Ext.toolbar.Paging',
        {
            displayInfo: true,
            displayMsg: '第{0} 到 {1} 条数据 共{2}条',
            emptyMsg: '没有数据',
            store: this.store
        }),

    tbar:[
        {
            xtype:'combo',
            fieldLabel:'采购商',
            store:Ext.create('MyApp.store.Buyer',{
                proxy:{
                    type:'ajax',
                    api:{
                        read:'../../buyer/getBuyerNameListForCombo',
                    },
                    reader:{
                        type:'json',
                        rootProperty:'data',
                    }
                },
            }),
            displayField: 'buyerName',
            valueField: 'buyerName',
            queryMode: 'remote',
            reference:'buyerName',
        },
        '-',
        {
            xtype:'button',
            text:'查询',
            listeners: {
                click: 'getBuyers'
            }
        },
        '-',
        {
            xtype:'button',
            text:'新增',
            listeners: {
                click: 'addBuyer'
            }
        },
        '-',
        {
            xtype:'button',
            text:'删除',
            listeners: {
                click: 'deleteBuyer'
            }
        },
    ],

    // listeners: {
    //     select: 'onItemSelected'
    // }
});

