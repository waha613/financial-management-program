Ext.define('MyApp.model.PayableStatistics', {
    extend: 'MyApp.model.Base',

    fields: [
        {name:'supplier',type: 'string'},
        {name:'startDate',type:'string'},
        {name:'endDate',type:'string'},
        {name:'purchaseAmount',type:'string'},
        {name:'actualPayment',type:'string'},
        {name:'balance',type:'string'},
    ],

});
