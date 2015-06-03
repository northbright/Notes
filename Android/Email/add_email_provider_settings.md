
# Add Email Provider Settings

#### Follow Predefined Providers Settings in
`packages/apps/Email/res/xml/providers.xml`:

        Valid incoming uri schemes are:
            imap        IMAP with no transport security.
            imap+tls+   IMAP with required TLS transport security.
                            If TLS is not available the connection fails.
            imap+ssl+   IMAP with required SSL transport security.
                            If SSL is not available the connection fails.

            pop3        POP3 with no transport security.
            pop3+tls+   POP3 with required TLS transport security.
                            If TLS is not available the connection fails.
            pop3+ssl+   POP3 with required SSL transport security.
                            If SSL is not available the connection fails.

        Valid outgoing uri schemes are:
            smtp        SMTP with no transport security.
            smtp+tls+   SMTP with required TLS transport security.
                            If TLS is not available the connection fails.
            smtp+ssl+   SMTP with required SSL transport security.
                            If SSL is not available the connection fails.

        To the above schemes you may also add "trustallcerts" to indicate that,
        although link encryption is still required, "non-trusted" certificates may
        will be excepted.  For example, "imap+ssl+trustallcerts" or
        "smtp+tls+trustallcerts".  This should only used when necessary, as it
        could allow a spoofed server to intercept password and mail.

        The URIs must contain all of the information to make a connection,
        including a port if the service uses a non-default port.  The default
        ports are as follows:
            imap        143     pop3        110     smtp        587
            imap+tls+   143     pop3+tls+   110     smtp+tls+   587
            imap+ssl+   993     pop3+ssl+   995     smtp+ssl+   465

    Ex:

    <provider id="gmail" label="Gmail" domain="gmail.com">
        <incoming uri="imap+ssl+://imap.gmail.com" username="$email" />
        <outgoing uri="smtp+ssl+://smtp.gmail.com" username="$email" />
    </provider>


    <!-- Hotmail and variants.  NOTE: These are handled by exchange if available, else POP3. -->
    <provider id="live1" label="Windows Live Hotmail Plus" domain="live.*">
        <incoming uri="eas+ssl+://m.hotmail.com"  username="$email" />
        <outgoing uri="eas+ssl+://m.hotmail.com" username="$email" />
        <incoming-fallback uri="imap+ssl+://imap-mail.outlook.com" username="$email" />
        <outgoing-fallback uri="smtp+tls+://smtp-mail.outlook.com" username="$email" />
    </provider>

You may copy the `<provider>` sectiton to your own `providers_product.xml` under the overlay folder.

#### Customized Port Setting

Ex: If you want to use different SMTP port(25):

`MY_OVERLAY/providers_product.xml`:

    <!-- mydomain -->
    <provider id="mydomain" label="mydomain" domain="mydomain.com">
        <incoming uri="imap://mail.mydomain.com"  username="$email" />
        <outgoing uri="smtp://mail.mydomain:25" username="$email" />
    </provider>
