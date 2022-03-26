Ext.define('MyApp.view.main.Main', {
    extend: 'Ext.container.Container',

    requires: [
        'MyApp.view.main.MainController',
        'MyApp.view.main.MainModel',
        'MyApp.view.trees.FinancialManageTrees',
        'MyApp.view.main.MainTop',
        'MyApp.view.main.ContentPanel'
    ],

    xtype: 'app-main-cls',

    controller: 'main',
    plugins: 'viewport',
    viewModel: {
        type: 'main'
    },

    layout: {
        type: 'border'
    },

    items: [
        {
            reference: 'mainTop',
            xtype: 'mainTop',
            region: 'north',
            collapsible: false,
            split: false,
            height: 50
        },
        {
            xtype: 'financialManageTrees',
            // bind: {
            //     title: '{name}'
            // },
            title:'导航菜单',
            region: 'west',
            width: 250,
            split: true,
            tbar: [{
                text: '注销',
                handler: 'onClickButton'
            }]
        }, {
            region: 'center',
            xtype: 'app-contentPanel',
        }]
});