Ext.define('MyApp.store.OutboundDetail', {
    extend: 'Ext.data.Store',

    alias: 'store.OutboundDetail',

    model: 'MyApp.model.OutboundDetail',

    proxy: {
        type: 'ajax',
        api: {
            read: '../../outboundDetail/getOutboundDetails',
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'totalRows',
        }
    },
    autoLoad: false,
});
