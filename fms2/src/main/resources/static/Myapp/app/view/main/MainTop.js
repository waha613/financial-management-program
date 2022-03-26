Ext.define('MyApp.view.main.MainTop', {
    extend: 'Ext.toolbar.Toolbar',
    xtype:'mainTop',

    style:'background-color:#35baf6;color:#fff;',
    items:[
        {
            xtype:'label',
            bind:{
                text:'fms'
            },
            style:'font-size:20px;font-weight:bold;'
        },
    ]

});