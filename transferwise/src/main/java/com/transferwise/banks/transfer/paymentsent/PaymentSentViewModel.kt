/*
 * Copyright 2019 TransferWise Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.transferwise.banks.transfer.paymentsent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.transferwise.banks.shared.NavigationAction
import com.transferwise.banks.shared.SharedViewModel
import com.transferwise.banks.util.TextProvider

internal class PaymentSentViewModel(
    private val sharedViewModel: SharedViewModel,
    amount: Float,
    currency: String,
    recipient: String,
    textProvider: TextProvider
) : ViewModel() {

    val uiState = MutableLiveData<PaymentSentUiState>()

    init {
        uiState.value = PaymentSentUiState(textProvider.paymentSummary(amount, currency, recipient))
    }

    fun doOnNextClicked() = sharedViewModel.navigationAction.setValue(NavigationAction.Done)
}
