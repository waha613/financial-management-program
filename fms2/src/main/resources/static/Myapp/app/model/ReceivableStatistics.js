Ext.define('MyApp.model.ReceivableStatistics', {
    extend: 'MyApp.model.Base',

    fields: [
        {name:'warehouse',type: 'string'},
        {name:'startDate',type:'string'},
        {name:'endDate',type:'string'},
        {name:'actualSales',type:'string'},
        {name:'actualReceive',type:'string'},
        {name:'balance',type:'string'},
    ],

});
