var toolbarTop = Ext.create('Ext.toolbar.Toolbar', {
    dock: 'top',
    items: [
        {
            xtype: 'combo',
            fieldLabel: '仓库',
            labelWidth: 60,
            width: 200,
            store: Ext.create('MyApp.store.Buyer', {
                autoLoad: true
            }),
            displayField: 'warehouse',
            valueField: 'warehouse',
            queryMode: 'remote',
            reference: 'warehouse',
        },
        '-',
        {
            xtype: 'datefield',
            labelWidth: 60,
            width: 200,
            format: 'Y-m-d',
            reference: 'receiveStartDate'
        },
        {
            xtype: 'datefield',
            fieldLabel: '至',
            labelWidth: 20,
            width: 200,
            format: 'Y-m-d',
            reference: 'receiveEndDate'
        },
        '-',
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
            reference: 'receiveMethod',
        },

        '-',
        {
            xtype: 'button',
            text: '查询收款记录',
            listeners: {
                click: 'getAccountsReceivable'
            }
        },
        '-',
        {
            xtype: 'button',
            text: '统计',
            listeners: {
                click: 'getAllAccountsReceivableStatistics'
            }
        },
        '-',
        {
            xtype: 'button',
            text: '应收账款余款统计',
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
            xtype: 'button',
            text: '新增收款记录',
            listeners: {
                click: 'addAccountReceivable'
            }
        },
        '-',
        {
            xtype: 'button',
            text: '编辑',
            listeners: {
                click: 'updateAccountReceivable'
            }
        },
        '-',
        {
            xtype: 'button',
            text: '删除',
            listeners: {
                click: 'deleteAccountReceivable'
            }
        },
    ]
});

Ext.define('MyApp.view.accountReceivable.AccountReceivable', {
    extend: 'Ext.grid.Panel',
    xtype: 'AccountReceivable',
    alias: 'view.AccountReceivable',
    controller: 'AccountReceivable',
    reference: 'AccountReceivable',
    viewConfig: {enableTextSelection: true},

    requires: [
        'MyApp.store.AccountReceivable',
        'MyApp.view.accountReceivable.AccountReceivableController',
    ],

    title: '收款记录',

    store: {
        type: 'AccountReceivable'
    },

    columns: [
        {text: '收款编号', dataIndex: 'receiveId', hidden: true},
        {text: '收款日期', dataIndex: 'receiveDate'},
        {text: '支付方', dataIndex: 'warehouse'},
        {text: '收款金额', dataIndex: 'actualSales'},
        {text: '收款方式', dataIndex: 'receiveMethod'},
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

