Ext.define('MyApp.store.FinancialManageTrees', {
    extend: 'Ext.data.TreeStore',

    alias: 'store.FinancialManageTrees',

    model:'MyApp.model.FinancialManageTrees',
    rootProperty: {
        expanded: true
    },
    autoLoad: true
});