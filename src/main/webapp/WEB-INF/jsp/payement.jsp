<%@ taglib prefix="button" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/importTags.jsp"%>



<div id="paypal-button-container"></div>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>
<script>
    // Render the PayPal button
    paypal.Button.render({
// Set your environment
        env: 'sandbox', // sandbox | production

// Specify the style of the button
        style: {
            layout: 'vertical',  // horizontal | vertical
            size:   'medium',    // medium | large | responsive
            shape:  'rect',      // pill | rect
            color:  'gold'       // gold | blue | silver | white | black
        },

// Specify allowed and disallowed funding sources
//
// Options:
// - paypal.FUNDING.CARD
// - paypal.FUNDING.CREDIT
// - paypal.FUNDING.ELV
        funding: {
            allowed: [
                paypal.FUNDING.CARD,
                paypal.FUNDING.CREDIT
            ],
            disallowed: []
        },

// PayPal Client IDs - replace with your own
// Create a PayPal app: https://developer.paypal.com/developer/applications/create
        client: {
            sandbox: 'AaQx0-E6l-2nlB9kQC12vB37A0nBDCBOtf_KgaATfVHk4PqRS6LIMS9s5AFCs-gKspvpFSqu52gfZ75i',
            production: '<insert production client id>'
        },

        payment: function (data, actions) {
            return actions.payment.create({
                payment: {
                    transactions: [
                        {
                            amount: {
                                total: "${total}",
                                currency: 'EUR'
                            }
                        }
                    ]
                }
            });
        },

        onAuthorize: function (data, actions) {
            return actions.payment.execute()
                .then(function () {

                    window.alert('Payment Complete!');
                    window.location.replace("http://localhost:8080/payement/setorderpaid")

                });
        }
    }, '#paypal-button-container');
</script>

