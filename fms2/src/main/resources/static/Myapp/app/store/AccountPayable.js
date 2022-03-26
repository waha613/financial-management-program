Ext.define('MyApp.store.AccountPayable', {
    extend: 'Ext.data.Store',

    alias: 'store.AccountPayable',

    model: 'MyApp.model.AccountPayable',

    proxy: {
        type: 'ajax',
        api: {
            read: '../../accountPayable/getAccountsPayable',
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'totalRows',
        }
    },
    autoLoad: false,
});
