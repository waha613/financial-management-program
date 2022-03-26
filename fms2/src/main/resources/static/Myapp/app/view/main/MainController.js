/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 */
Ext.define('MyApp.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    requires: [
        'Ext.window.MessageBox',
        'MyApp.view.inboundDetails.InboundDetails',
        'MyApp.view.buyer.Buyer',
        'MyApp.view.myProduct.MyProduct',
        'MyApp.view.supplier.Supplier',
        'MyApp.view.outboundDetail.OutboundDetail',
        'MyApp.view.accountPayable.AccountPayable',
        'MyApp.view.accountReceivable.AccountReceivable'
    ],

    routes: {
        ':id': 'handleRoute'//执行路由
    },

    handleRoute: function (id) {
        var me = this,
            mainView = me.getView(),
            contentPanel = mainView.down('app-contentPanel');

        // contentPanel.removeAll();
        var item = contentPanel.getComponent(id);

        if (!item) {
            var myPanel = Ext.create('view.' + id, {
                closable: true,
                bodyPadding: 0,
                itemId: id,
                closeAction:'hide',

            });
            contentPanel.add(myPanel);
            contentPanel.setActiveItem(myPanel);
        }
        contentPanel.setActiveItem(item);
    },

    onTreeFinSelectionChange: function (view, record, item, index, clickEvent) {
        var controller = Ext.create('MyApp.view.trees.FinancialManageTreesController');
        controller.onTreeFinSelectionChange(view, record, item, index, clickEvent);
    },

    // onItemSelected: function (sender, record) {
    //     Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    // },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    },

    onClickButton: function () {

        // Remove the localStorage key/value
        localStorage.removeItem('TutorialLoggedIn');

        // Remove Main View
        this.getView().destroy();

        // Add the Login Window
        Ext.widget('login');

    },

    // getInboundDetails: function () {
    //     var controller = Ext.create('MyApp.view.inboundDetails.InboundDetailsController');
    //     controller.getInboundDetails()
    // }
});
