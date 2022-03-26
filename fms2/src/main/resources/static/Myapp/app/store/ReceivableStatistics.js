Ext.define('MyApp.store.ReceivableStatistics', {
    extend: 'Ext.data.Store',

    alias: 'store.ReceivableStatistics',

    model: 'MyApp.model.ReceivableStatistics',

    proxy:{
        type:'ajax',
        api:{
            read:'../../receivableAndPayableStatistics/getReceivableStatistics',
        },
        reader:{
            type:'json',
            rootProperty: 'data',
        }
    },
    autoLoad:true,
});

