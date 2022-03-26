Ext.define('MyApp.view.PayableStatistics', {
    extend: 'Ext.grid.Panel',
    xtype: 'PayableStatistics',
    alias: 'view.PayableStatistics',
    reference: 'PayableStatistics',
    viewConfig: {enableTextSelection: true},

    requires: [
        'MyApp.store.PayableStatistics',
    ],
            // title: '应付账款统计',

            store: {
                type: 'PayableStatistics'
            },

            columns: [
                {text: '供应商', dataIndex: 'supplier', hidden: true},
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
                    store: this.store
                }),
            // listeners: {
            //     select: 'onItemSelected'
            // }

});

