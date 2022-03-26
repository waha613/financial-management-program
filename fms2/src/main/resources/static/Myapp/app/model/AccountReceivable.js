Ext.define('MyApp.model.AccountReceivable', {
    extend: 'MyApp.model.Base',

    fields: [
        {name:'receiveId',type: 'string'},
        {name:'receiveDate',type:'string'},
        {name:'warehouse',type:'string'},
        {name:'actualSales',type:'number'},
        {name:'receiveMethod',type:'string'},
        {name:'comment',type:'string'},
    ],

});
