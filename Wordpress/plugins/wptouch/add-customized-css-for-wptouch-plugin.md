# Add Customized CSS for WPTouch Plugin

#### Steps
1. Copy your CSS file to `path/to/wordpress/wp-content/plugins/wptouch/themes/foundation/default`:

        cp mytable.css path/to/wordpress/wp-content/plugins/wptouch/themes/foundation/default/

2. Modify `path/to/wordpress/wp-content/plugins/wptouch/core/globals.php`

        function wptouch_foundation_load_framework_styles() {
                wp_enqueue_style( 'foundation-framework-style', WPTOUCH_URL . '/themes/foundation/default/style.css', false, md5( WPTOUCH_VERSION ) );
                // Add customized css here
                wp_enqueue_style( 'mytable-style', WPTOUCH_URL . '/themes/foundation/default/mytable.css', false, md5( WPTOUCH_VERSION ) );

        }

