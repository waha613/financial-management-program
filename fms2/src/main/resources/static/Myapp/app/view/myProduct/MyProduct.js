Ext.define('MyApp.view.myProduct.MyProduct', {
    extend: 'Ext.grid.Panel',
    xtype: 'MyProduct',
    alias: 'view.MyProduct',
    controller:'MyProduct',
    reference:'MyProduct',
    viewConfig : {enableTextSelection:true},

    requires: [
        'MyApp.store.MyProduct',
        'MyApp.view.myProduct.MyProductController',
    ],

    title: '产品信息',

    store: {
        type: 'MyProduct'
    },

    columns: [
        {text: '产品编号',dataIndex:'productID'},
        {text: '产品名称',dataIndex:'productName'},
        {text: '产品规格',dataIndex:'standard'},
        {text: '子产品数量',dataIndex:'itemQuantity'},
        {text: '单个子产品重量',dataIndex:'oneItemWeight'},
        {text: '产品重量',dataIndex:'oneProductWeight'},
        {text: '重量单位',dataIndex:'unit'},
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
            xtype:'button',
            text:'查询',
            listeners: {
                click: 'getProducts'
            }
        },
        '-',
        {
            xtype:'button',
            text:'新增',
            listeners: {
                click: 'addProduct'
            }
        },
        // '-',
        // {
        //     xtype:'button',
        //     text:'编辑',
        //     listeners: {
        //         click: 'updateProduct'
        //     }
        // },
        '-',
        {
            xtype:'button',
            text:'删除',
            listeners: {
                click: 'deleteProduct'
            }
        },
    ],

    // listeners: {
    //     select: 'onItemSelected'
    // }
});

