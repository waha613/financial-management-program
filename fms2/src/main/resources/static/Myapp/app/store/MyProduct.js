Ext.define('MyApp.store.MyProduct', {
    extend: 'Ext.data.Store',

    alias: 'store.MyProduct',

    model: 'MyApp.model.MyProduct',

    proxy:{
        type:'ajax',
        api:{
            read:'../../product/getProducts',
        },
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'totalRows',
        }
    },
    autoLoad: true,
});
