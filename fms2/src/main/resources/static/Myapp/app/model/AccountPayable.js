Ext.define('MyApp.model.AccountPayable', {
    extend: 'MyApp.model.Base',

    fields: [
        {name:'payID',type: 'string'},
        {name:'supplier',type:'string'},
        {name:'payDate',type:'string'},
        {name:'amountOfThisPurchase',type:'number'},
        {name:'paymentMethod',type:'string'},
        {name:'comment',type:'string'},
    ],

});
