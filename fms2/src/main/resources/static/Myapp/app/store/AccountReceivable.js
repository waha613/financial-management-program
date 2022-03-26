Ext.define('MyApp.store.AccountReceivable', {
    extend: 'Ext.data.Store',

    alias: 'store.AccountReceivable',

    model: 'MyApp.model.AccountReceivable',

    proxy: {
        type: 'ajax',
        api: {
            read: '../../accountReceivable/getAccountsReceivable',
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'totalRows',
        }
    },
    autoLoad: false,
});
