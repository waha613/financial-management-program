Ext.define('MyApp.store.InboundDetails', {
    extend: 'Ext.data.Store',

    alias: 'store.InboundDetails',

    model: 'MyApp.model.InboundDetails',

    proxy: {
        type: 'ajax',
        api: {
            read: '../../inboundDetails/getInboundDetails',
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'totalRows',
        }
    },
    autoLoad: false,
});
