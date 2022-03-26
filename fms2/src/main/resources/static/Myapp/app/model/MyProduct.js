Ext.define('MyApp.model.MyProduct', {
    extend: 'MyApp.model.Base',

    fields: [
        {name:'productID',type: 'string'},
        {name:'productName',type: 'string'},
        {name:'standard',type: 'string'},
        {name:'itemQuantity',type: 'number'},
        {name:'oneItemWeight',type: 'number'},
        {name:'oneProductWeight',type: 'number'},
        {name:'unit',type: 'string'},
    ],

});
