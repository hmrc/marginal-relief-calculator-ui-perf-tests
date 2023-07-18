/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.example

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.example.MarginalReliefCalculatorRequestsRequests._

class MarginalReliefCalculatorSimulation extends PerformanceTestRunner {

  setup("get-index-page", "Start Page") withRequests indexPage

  setup("get-accounting-period-page", "Accounting period page") withRequests accountingPeriodPage

  setup("post-accounting-period-page", "Accounting period page") withRequests postAccountingPeriodPage

  setup("get-taxable-profit-page", "Taxable profit page") withRequests taxableProfitPage

  setup("post-taxable-profit-page", "Taxable profit page") withRequests postTaxableProfitPage

  setup("get-distribution-page", "Distribution page") withRequests distributionPage

  setup("post-distribution-page", "Distribution page") withRequests postDistributionPage

  setup("get-distributions-included-page", "Distributions included page") withRequests distributionsIncludedPage

  setup(
    "post-distributions-included-page",
    "Distributions included page"
  ) withRequests postDistributionsIncludedPage

  setup("get-associated-companies-page", "Associated companies page") withRequests associatedCompaniesPage

  setup("post-associated-companies-page", "Associated companies page") withRequests postAssociatedCompaniesPage

  setup("get-check-your-answers-page", "Check your answers page") withRequests checkYourAnswersPage

  setup("get-results-page", "Results page") withRequests resultsPage

  setup("get-full-results-page", "Full Results Page") withRequests fullResultsPage

  setup("get-pdf-meta-data-page", "PDF meta data page") withRequests pdfMetaDataPage

  setup("post-pdf-meta-data-page", "PDF meta data page") withRequests postPdfMetaDataPage

  setup("get-pdf-page", "PDF Page") withRequests pdfPage

  setup("get-pdf-save-page", "PDF save page") withRequests savePdfPage

  runSimulation()
}
