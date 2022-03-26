Ext.define('MyApp.model.FinancialManageTrees',{
    extend:'Ext.data.TreeModel',
    fields: [
        {name:'id',type: 'string'},
        {name:'parentId',type: 'string'},
        {name:'name',type: 'string'},
        {name:'leaf',type: 'boolean'},
        {name:'expanded',type: 'boolean'},
        {name:'href',type: 'string'},
    ],
})