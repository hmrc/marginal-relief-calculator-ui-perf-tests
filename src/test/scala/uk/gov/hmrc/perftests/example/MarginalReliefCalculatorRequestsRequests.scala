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

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object MarginalReliefCalculatorRequestsRequests extends ServicesConfiguration {

  val baseUrl: String = baseUrlFor("marginal-relief-calculator-frontend")
  val route: String   = "/marginal-relief-calculator"

  val indexPage: HttpRequestBuilder =
    http("Index page")
      .get(s"$baseUrl$route")
      .check(status.is(200))

  val accountingPeriodPage: HttpRequestBuilder =
    http("Accounting period page")
      .get(s"$baseUrl$route/accounting-period")
      .check(status.is(200))
      .check(saveCsrfToken)

  val postAccountingPeriodPage: HttpRequestBuilder =
    http("Post accounting period page")
      .post(s"$baseUrl$route/accounting-period": String)
      .formParam("accountingPeriodStartDate.day", "01")
      .formParam("accountingPeriodStartDate.month", "01")
      .formParam("accountingPeriodStartDate.year", "2023")
      .formParam("accountingPeriodEndDate.day", "31")
      .formParam("accountingPeriodEndDate.month", "12")
      .formParam("accountingPeriodEndDate.year", "2023")
      .formParam("csrfToken", s"$${csrfToken}")
      .check(status.is(303))
      .check(header("Location").is(s"$route/taxable-profit").saveAs("taxableProfitPage"))

  val taxableProfitPage: HttpRequestBuilder =
    http("Get taxable profit page")
      .get(s"$baseUrl$${taxableProfitPage}": String)
      .check(status.is(200))
      .check(saveCsrfToken)

  val postTaxableProfitPage: HttpRequestBuilder =
    http("Post taxable profit page")
      .post(s"$baseUrl$${taxableProfitPage}": String)
      .formParam("value", "100000")
      .formParam("csrfToken", s"$${csrfToken}")
      .check(status.is(303))
      .check(header("Location").is(s"$route/distribution").saveAs("distributionPage"))

  val distributionPage: HttpRequestBuilder =
    http("Get distribution page")
      .get(s"$baseUrl$${distributionPage}": String)
      .check(status.is(200))
      .check(saveCsrfToken)

  val postDistributionPage: HttpRequestBuilder =
    http("Post distribution page")
      .post(s"$baseUrl$${distributionPage}": String)
      .formParam("distribution", "yes")
      .formParam("csrfToken", s"$${csrfToken}")
      .check(status.is(303))
      .check(header("Location").is(s"$route/distributionsIncluded").saveAs("distributionsIncludedPage"))

  val distributionsIncludedPage: HttpRequestBuilder =
    http("Get distributions included page")
      .get(s"$baseUrl$${distributionsIncludedPage}": String)
      .check(status.is(200))
      .check(saveCsrfToken)

  val postDistributionsIncludedPage: HttpRequestBuilder =
    http("Post distributions included page")
      .post(s"$baseUrl$${distributionsIncludedPage}": String)
      .formParam("distributionsIncluded", "yes")
      .formParam("distributionsIncludedAmount", "10000")
      .formParam("csrfToken", s"$${csrfToken}")
      .check(status.is(303))
      .check(header("Location").is(s"$route/associated-companies").saveAs("associatedCompaniesPage"))

  val associatedCompaniesPage: HttpRequestBuilder =
    http("Get associated companies page")
      .get(s"$baseUrl$${associatedCompaniesPage}": String)
      .check(status.is(200))
      .check(saveCsrfToken)

  val postAssociatedCompaniesPage: HttpRequestBuilder =
    http("Post associated companies page")
      .post(s"$baseUrl$${associatedCompaniesPage}": String)
      .formParam("associatedCompanies", "yes")
      .formParam("associatedCompaniesCount", "1")
      .formParam("csrfToken", s"$${csrfToken}")
      .check(status.is(303))
      .check(header("Location").is(s"$route/check-your-answers").saveAs("checkYourAnswersPage"))

  val checkYourAnswersPage: HttpRequestBuilder =
    http("Get check your answers page")
      .get(s"$baseUrl$${checkYourAnswersPage}": String)
      .check(status.is(200))

  val resultsPage: HttpRequestBuilder =
    http("Get results page")
      .get(s"$baseUrl$route/results-page": String)
      .check(status.is(200))

  def saveCsrfToken = regex("""name="csrfToken" value="([^"]+)"""").saveAs("csrfToken")
}
