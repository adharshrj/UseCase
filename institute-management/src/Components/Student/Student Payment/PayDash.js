import React from 'react'
import Payment from './Payment'
export default function PayDash() {
    return (
        <div>
            <h2>PAY SEMESTER FEES</h2> <Payment price="95000"/><br/>
            <h2>PAY EXAM FEES</h2> <Payment price="6000"/><br/>
            <h2>PAY ORTHER FEES</h2> <Payment price="4000"/><br/>
        </div>
    )
}
