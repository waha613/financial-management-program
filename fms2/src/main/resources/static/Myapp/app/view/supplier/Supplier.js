Ext.define('MyApp.view.supplier.Supplier', {
    extend: 'Ext.grid.Panel',
    xtype: 'Supplier',
    alias: 'view.Supplier',
    controller:'Supplier',
    reference:'Supplier',
    viewConfig : {enableTextSelection:true},

    requires: [
        'MyApp.store.Supplier',
        'MyApp.view.supplier.SupplierController',
    ],

    title: '供应商信息',

    store: {
        type: 'Supplier'
    },

    columns: [
        {text: '供应商名称',dataIndex:'supplierID'},
        {text: '供应商电话',dataIndex:'phone'},
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
                click: 'getSuppliers'
            }
        },
        '-',
        {
            xtype:'button',
            text:'新增',
            listeners: {
                click: 'addSupplier'
            }
        },
        '-',
        {
            xtype:'button',
            text:'修改',
            listeners: {
                click: 'updateSupplier'
            }
        },
        '-',
        {
            xtype:'button',
            text:'删除',
            listeners: {
                click: 'deleteSupplier'
            }
        },
    ],

    // listeners: {
    //     select: 'onItemSelected'
    // }
});

