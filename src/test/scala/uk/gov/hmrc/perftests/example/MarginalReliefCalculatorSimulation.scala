/*
 * Copyright 2022 HM Revenue & Customs
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

  setup("get-index-page", "Index Page") withRequests indexPage

  setup("get-accounting-period-page", "Get accounting period page") withRequests accountingPeriodPage

  setup("post-accounting-period-page", "Post accounting period page") withRequests postAccountingPeriodPage

  setup("get-taxable-profit-page", "Get taxable profit page") withRequests taxableProfitPage

  setup("post-taxable-profit-page", "Post accounting period page") withRequests postTaxableProfitPage

  setup("get-distribution-page", "Get distribution page") withRequests distributionPage

  setup("post-distribution-page", "Post distribution page") withRequests postDistributionPage

  setup("get-distributions-included-page", "Get distributions included page") withRequests distributionsIncludedPage

  setup(
    "post-distributions-included-page",
    "Post distributions included page"
  ) withRequests postDistributionsIncludedPage

  setup("get-associated-companies-page", "Get associated companies page") withRequests associatedCompaniesPage

  setup("post-associated-companies-page", "Post associated companies page") withRequests postAssociatedCompaniesPage

  setup("get-check-your-answers-page", "Get check your answers page") withRequests checkYourAnswersPage

  setup("get-results-page", "Get results page") withRequests resultsPage

  runSimulation()
}
