Ext.define('MyApp.store.Supplier', {
    extend: 'Ext.data.Store',

    alias: 'store.Supplier',

    model: 'MyApp.model.Supplier',

    proxy:{
        type:'ajax',
        api:{
            read:'../../supplier/getSuppliers',
        },
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'totalRows',
        }
    },
    autoLoad: false,
});
