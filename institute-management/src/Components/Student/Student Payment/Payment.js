import React from "react";
import axios from "axios";
import StripeCheckout from "react-stripe-checkout";
import school from "./school.png";
function Payment({price}) {
    const myKey = 'pk_test_51IBJn0GSzWULkfugLzKzoAWUsjWjA6arT6H549Q2lsMY9cMbKxtSdO3LugKY6Ab280XoCPUOzsVLJ56LYoBPyViv00YEl2Jdes';
    const sp = price;

async function handleToken(token) {
console.log(token);
await axios.post("http://localhost:4200/api/payment/charge", "", {         headers: {
  token: token.id,
  amount: sp,
},}).then(() => {
   alert("Payment Success");
   }).catch((error) => {
   alert(error);
   });

}
return (
<div className="Payment">
<StripeCheckout
label="Pay Fees"
name="Leading Institute"
image={school}
description={`Your Total is INR ${price}`}
panelLabel="Pay Now"
stripeKey={myKey}
token={handleToken}
currency="INR"
/>
</div>
);
}
export default Payment;