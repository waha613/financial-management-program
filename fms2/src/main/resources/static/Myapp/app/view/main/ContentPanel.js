Ext.define('MyApp.view.main.ContentPanel', {
    extend: 'Ext.tab.Panel',
    xtype: 'app-contentPanel',

    requires: [
        'Ext.ux.TabCloseMenu'
    ],
    autoScroll: true,
    deferredRender: false,
    autoDestroy: false,
    plugins: Ext.create('Ext.ux.TabCloseMenu', {
        closeTabText: '关闭当前',
        closeOtherTabsText: '关闭其他',
        closeAllTabsText: '关闭所有',
    }),

});