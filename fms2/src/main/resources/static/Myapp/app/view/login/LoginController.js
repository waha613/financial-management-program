Ext.define('MyApp.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',

    onLoginClick: function (record) {
        var form = this.lookupReference('form')
        var view = this.getView()

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.submit({
                // Ext.Ajax.request({
                //     url: '../../login/checkLogin',
                //     params: {
                //         username: record.get('username'),
                //         password: record.get('password')
                //     },
                success: function (form, action) {
                    // var res = Ext.decode(response.responseText);
                    if (action.result.success) {
                        // This would be the ideal location to verify the user's credentials via
                        // a server-side lookup. We'll just move forward for the sake of this example.

                        // Set the localStorage value to true
                        localStorage.setItem("TutorialLoggedIn", true);

                        // Remove Login Window
                        view.destroy();

                        // Add the main view to the viewport
                        Ext.widget('app-main-cls');
                    } else {
                        Ext.Msg.alert('ERROR', res.data);
                    }
                },
                failure: function (form, action) {
                    Ext.Msg.alert('Failed', action.result.data);
                },
            });
        }
    }
});