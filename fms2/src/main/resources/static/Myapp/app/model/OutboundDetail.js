Ext.define('MyApp.model.OutboundDetail', {
    extend: 'MyApp.model.Base',

    fields: [
        {name:'outboundId',type: 'string'},
        {name:'outboundDate',type:'string'},
        {name:'warehouse',type:'string'},
        {name:'productID',type:'string'},
        {name:'unit',type:'string'},
        {name:'unitSalePrice',type:'number'},
        {name:'outboundQuantity',type:'number'},
        {name:'amountOfThisSale',type:'number'},
        {name:'saleFee',type:'number'},
        {name:'saleFeeType',type:'string'},
        {name:'actualSales',type:'number'},
        {name:'comment',type:'string'},
    ],

});
