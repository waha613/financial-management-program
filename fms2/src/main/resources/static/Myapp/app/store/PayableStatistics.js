Ext.define('MyApp.store.PayableStatistics', {
    extend: 'Ext.data.Store',

    alias: 'store.PayableStatistics',

    model: 'MyApp.model.PayableStatistics',

    proxy:{
        type:'ajax',
        api:{
            read:'../../receivableAndPayableStatistics/getPayableStatistics',
        },
        reader:{
            type:'json',
            rootProperty:'data',
        }
    },
    autoLoad:true,
});
