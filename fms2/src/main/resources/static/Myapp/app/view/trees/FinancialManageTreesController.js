Ext.define('MyApp.view.trees.FinancialManageTreesController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.FinancialManageTrees',

    onTreeFinSelectionChange: function (view, record, item, index, clickEvent) {
        this.redirectTo(record.raw.id)
    },
})