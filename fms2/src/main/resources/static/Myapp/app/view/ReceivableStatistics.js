Ext.define('MyApp.view.ReceivableStatistics', {
    extend: 'Ext.grid.Panel',
    xtype: 'ReceivableStatistics',
    alias: 'view.ReceivableStatistics',
    reference: 'ReceivableStatistics',
    viewConfig: {enableTextSelection: true},

    requires: [
        'MyApp.store.ReceivableStatistics',
    ],
    // title: '应付账款统计',

    store: {
        type: 'ReceivableStatistics'
    },

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
            store: this.store
        }),
    // listeners: {
    //     select: 'onItemSelected'
    // }

});

