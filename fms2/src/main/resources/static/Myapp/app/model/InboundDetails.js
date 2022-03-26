Ext.define('MyApp.model.InboundDetails', {
    extend: 'MyApp.model.Base',

    fields: [
        {name:'inboundId',type: 'string'},
        {name:'supplier',type:'string'},
        {name:'inboundDate',type:'string'},
        {name:'productID',type:'string'},
        {name:'unit',type:'string'},
        {name:'unitPrice',type:'number'},
        {name:'inboundQuantity',type:'number'},
        {name:'amountOfThisPurchase',type:'number'},
        {name:'purchaseFee',type:'number'},
        {name:'purchaseFeeType',type:'string'},
        {name:'actualPayment',type:'number'},
        {name:'warehouse',type:'string'},
        {name:'comment',type:'string'},
    ],

});
