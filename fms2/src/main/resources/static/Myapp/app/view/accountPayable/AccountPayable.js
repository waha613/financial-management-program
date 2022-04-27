// var toolbarTop = Ext.create('Ext.toolbar.Toolbar', {
//     dock: 'top',
//     items: [
//         {
//             xtype: 'combo',
//             fieldLabel: '供应商',
//             labelWidth: 60,
//             width: 200,
//             store: Ext.create('MyApp.store.Supplier', {
//                 autoLoad: true
//             }),
//             displayField: 'supplierID',
//             valueField: 'supplierID',
//             queryMode: 'remote',
//             reference: 'supplier',
//         },
//         '-',
//         {
//             xtype: 'datefield',
//             labelWidth: 60,
//             width: 200,
//             format: 'Y-m-d',
//             reference: 'payStartDate'
//         },
//         {
//             xtype: 'datefield',
//             fieldLabel: '至',
//             labelWidth: 20,
//             width: 200,
//             format: 'Y-m-d',
//             reference: 'payEndDate'
//         },
//         '-',
//         {
//             xtype: 'button',
//             text: '查询付款记录',
//             listeners: {
//                 click: 'getAccountsPayable'
//             }
//         },
//         '-',
//         {
//             xtype: 'button',
//             text: '统计',
//             listeners: {
//                 click: 'getAllAccountPayableStatistics'
//             }
//         },
//     ]
// });
//
// var toolbarBottom = Ext.create('Ext.toolbar.Toolbar', {
//     style: {
//         borderTopWidth: '0px !important',
//         borderBottomWidth: '1px !important'
//     },
//     items: [
//         {
//             xtype: 'button',
//             text: '新增付款记录',
//             listeners: {
//                 click: 'addAccountPayable'
//             }
//         },
//         '-',
//         {
//             xtype: 'button',
//             text: '编辑',
//             listeners: {
//                 click: 'updateAccountPayable'
//             }
//         },
//         '-',
//         {
//             xtype: 'button',
//             text: '删除',
//             listeners: {
//                 click: 'deleteAccountPayable'
//             }
//         },
//     ]
// });

Ext.define('MyApp.view.accountPayable.AccountPayable', {
    extend: 'Ext.grid.Panel',
    xtype: 'AccountPayable',
    alias: 'view.AccountPayable',
    controller: 'AccountPayable',
    reference: 'AccountPayable',
    viewConfig: {enableTextSelection: true},

    requires: [
        'MyApp.store.AccountPayable',
        'MyApp.view.accountPayable.AccountPayableController',
    ],

    initComponent: function () {
        var toolbarTop = Ext.create('Ext.toolbar.Toolbar', {
            dock: 'top',
            items: [
                {
                    xtype: 'combo',
                    fieldLabel: '供应商',
                    labelWidth: 60,
                    width: 200,
                    store: Ext.create('MyApp.store.Supplier', {
                        autoLoad: true
                    }),
                    displayField: 'supplierID',
                    valueField: 'supplierID',
                    queryMode: 'remote',
                    reference: 'supplier',
                },
                '-',
                {
                    xtype: 'datefield',
                    labelWidth: 60,
                    width: 200,
                    format: 'Y-m-d',
                    reference: 'payStartDate'
                },
                {
                    xtype: 'datefield',
                    fieldLabel: '至',
                    labelWidth: 20,
                    width: 200,
                    format: 'Y-m-d',
                    reference: 'payEndDate'
                },

                '-',
                {
                    xtype: 'combo',
                    fieldLabel: '付款方式',
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
                    reference: 'paymentMethod',
                },
                '-',
                {
                    xtype: 'button',
                    text: '查询付款记录',
                    listeners: {
                        click: 'getAccountsPayable'
                    }
                },
                '-',
                {
                    xtype: 'button',
                    text: '付款记录统计',
                    listeners: {
                        click: 'getAllAccountPayableStatistics'
                    }
                },
                '-',
                {
                    xtype: 'button',
                    text: '未支付余款统计',
                    listeners: {
                        click: 'getPayableStatistics'
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
                    text: '新增付款记录',
                    listeners: {
                        click: 'addAccountPayable'
                    }
                },
                '-',
                {
                    xtype: 'button',
                    text: '编辑',
                    listeners: {
                        click: 'updateAccountPayable'
                    }
                },
                '-',
                {
                    xtype: 'button',
                    text: '删除',
                    listeners: {
                        click: 'deleteAccountPayable'
                    }
                },
            ]
        });
        Ext.apply(this, {
            title: '付款记录',

            store: {
                type: 'AccountPayable'
            },

            columns: [
                {text: '付款编号', dataIndex: 'payID', hidden: true},
                {text: '付款日期', dataIndex: 'payDate'},
                {text: '收款方', dataIndex: 'supplier'},
                {text: '支付金额', dataIndex: 'amountOfThisPurchase'},
                {text: '支付方式', dataIndex: 'paymentMethod'},
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
        this.callParent(arguments);
    }
});

