Ext.define('MyApp.view.trees.FinancialManageTrees', {
    extend: 'Ext.tree.Panel',
    xtype: 'financialManageTrees',
    requires: [
        'MyApp.store.FinancialManageTrees',
        'MyApp.view.trees.FinancialManageTreesController',
    ],
    lines: false,
    rootVisible:false,
    useArrows:true,
    hideHeaders:true,
    width:250,
    minWidth:100,
    split:true,
    collapsible:true,
    store: {
        type: 'FinancialManageTrees',
        proxy: {
            type: 'ajax',
            api : {
                read:'/getFinancialManageTrees'
            }
        }
    },
    columns: [{
        xtype: 'treecolumn',
        dataIndex: 'name',
        flex: 1
    }],
    listeners: {
        itemclick: 'onTreeFinSelectionChange'
    }
});