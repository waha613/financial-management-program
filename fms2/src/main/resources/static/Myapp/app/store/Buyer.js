Ext.define('MyApp.store.Buyer', {
    extend: 'Ext.data.Store',

    alias: 'store.Buyer',

    model: 'MyApp.model.Buyer',

    proxy:{
        type:'ajax',
        api:{
            read:'../../buyer/getBuyers',
        },
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'totalRows',
        }
    },
    autoLoad: false,
});
