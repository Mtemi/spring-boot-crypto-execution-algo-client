package com.ismail.algo;

/**
 * FIX Constants
 * 
 * @author ismail
 * @since 20221126
 */
public class FIXTags
{
    public static final byte SOH = 1;

    public static final byte FIELDDELIMITER = 1;

    public static final int CHECKSUMFIELDSIZE = 7;

    public static final int DIGESTSIZE = 16;

    public static final int SIGNATURELENGTHFIELDSIZE = 6;

    public static final int SIGNATUREFIELDSIZE = 20;

    public static final int MAXFIRSTTWOFIELDSIZE = 100;

    public static final int NUMUnencryptedReqdHdrFields = 5;

    public static final String BOOLEAN_True = "Y";

    public static final String BOOLEAN_False = "N";

    public static final int ENC_None = 0;

    public static final int ENC_PKCS = 1;

    public static final int ENC_DES = 2;

    public static final int ENC_PKCS_DES = 3;

    public static final int ENC_PGP_DES = 4;

    public static final int ENC_PGP_DES_MD5 = 5;

    public static final int ENC_PEM_DES_MD5 = 6;

    public static final String ENCODE_None = "";

    public static final String ENCODE_ISO_2022_JP = "ISO-2022-JP";

    public static final String ENCODE_EUC_JP = "EUC-JP";

    public static final String ENCODE_Shift_JIS = "Shift_JIS";

    public static final String ENCODE_UTF_8 = "UTF-8";

    public static final String MSGAdvertisement = "7";

    public static final String MSGAllocation = "J";

    public static final String MSGAllocationACK = "P";

    public static final String MSGAllocationInstruction = "J";

    public static final String MSGAllocationInstructionAck = "P";

    public static final String MSGAllocationReport = "AS";

    public static final String MSGAllocationReportAck = "AT";

    public static final String MSGAssignmentReport = "AW";

    public static final String MSGBidRequest = "k";

    public static final String MSGBidResponse = "l";

    public static final String MSGBusinessMessageReject = "j";

    public static final String MSGCollateralAssignment = "AY";

    public static final String MSGCollateralInquiry = "BB";

    public static final String MSGCollateralInquiryAck = "BG";

    public static final String MSGCollateralReport = "BA";

    public static final String MSGCollateralRequest = "AX";

    public static final String MSGCollateralResponse = "AZ";

    public static final String MSGConfirmation = "AK";

    public static final String MSGConfirmationAck = "AU";

    public static final String MSGConfirmationRequest = "BH";

    public static final String MSGCrossOrderCancelReplaceRequest = "t";

    public static final String MSGCrossOrderCancelRequest = "u";

    public static final String MSGDerivativeSecurityList = "AA";

    public static final String MSGDerivativeSecurityListRequest = "z";

    public static final String MSGDK = "Q";

    public static final String MSGDontKnowTrade = "Q";

    public static final String MSGEmail = "C";

    public static final String MSGExecution = "8";

    public static final String MSGExecutionReport = "8";

    public static final String MSGHeartbeat = "0";

    public static final String MSGIndicationOfInterest = "6";

    public static final String MSGIOI = "6";

    public static final String MSGListCancelRequest = "K";

    public static final String MSGListExecute = "L";

    public static final String MSGListStatus = "N";

    public static final String MSGListStatusRequest = "M";

    public static final String MSGListStrikePrice = "m";

    public static final String MSGLogon = "A";

    public static final String MSGLogout = "5";

    public static final String MSGMarketDataIncrementalRefresh = "X";

    public static final String MSGMarketDataRequest = "V";

    public static final String MSGMarketDataRequestReject = "Y";

    public static final String MSGMarketDataSnapshot = "W";

    public static final String MSGMarketDataSnapshotFullRefresh = "W";

    public static final String MSGMassQuote = "i";

    public static final String MSGMassQuoteAcknowledgement = "b";

    public static final String MSGMultilegOrderCancelReplace = "AC";

    public static final String MSGMultilegOrderCancelReplaceRequest = "AC";

    public static final String MSGNetworkStatusRequest = "BC";

    public static final String MSGNetworkStatusResponse = "BD";

    public static final String MSGNewOrderCross = "s";

    public static final String MSGNewOrderMultileg = "AB";

    public static final String MSGNews = "B";

    public static final String MSGOrder = "D";

    public static final String MSGOrderCancelReject = "9";

    public static final String MSGOrderCancelReplaceRequest = "G";

    public static final String MSGOrderCancelRequest = "F";

    public static final String MSGOrderList = "E";

    public static final String MSGOrderMassCancelReport = "r";

    public static final String MSGOrderMassCancelRequest = "q";

    public static final String MSGOrderMassStatusRequest = "AF";

    public static final String MSGOrderSingle = "D";

    public static final String MSGOrderStatusRequest = "H";

    public static final String MSGPositionMaintenanceReport = "AM";

    public static final String MSGPositionMaintenanceRequest = "AL";

    public static final String MSGPositionReport = "AP";

    public static final String MSGQuote = "S";

    public static final String MSGQuoteAcknowledgement = "b";

    public static final String MSGQuoteCancel = "Z";

    public static final String MSGQuoteRequest = "R";

    public static final String MSGQuoteRequestReject = "AG";

    public static final String MSGQuoteResponse = "AJ";

    public static final String MSGQuoteStatusReport = "AI";

    public static final String MSGQuoteStatusRequest = "a";

    public static final String MSGRegistrationInstructions = "o";

    public static final String MSGRegistrationInstructionsResponse = "p";

    public static final String MSGReject = "3";

    public static final String MSGRequestForPositions = "AN";

    public static final String MSGRequestForPositionsAck = "AO";

    public static final String MSGResendRequest = "2";

    public static final String MSGRFQRequest = "AH";

    public static final String MSGSecurityDefinition = "d";

    public static final String MSGSecurityDefinitionRequest = "c";

    public static final String MSGSecurityList = "y";

    public static final String MSGSecurityListRequest = "x";

    public static final String MSGSecurityStatus = "f";

    public static final String MSGSecurityStatusRequest = "e";

    public static final String MSGSecurityTypeRequest = "v";

    public static final String MSGSecurityTypes = "w";

    public static final String MSGSequenceReset = "4";

    public static final String MSGSettlement = "T";

    public static final String MSGSettlementInstructionRequest = "AV";

    public static final String MSGSettlementInstructions = "T";

    public static final String MSGTestRequest = "1";

    public static final String MSGTradeCaptureReport = "AE";

    public static final String MSGTradeCaptureReportAck = "AR";

    public static final String MSGTradeCaptureReportRequest = "AD";

    public static final String MSGTradeCaptureReportRequestAck = "AQ";

    public static final String MSGTradingSessionStatus = "h";

    public static final String MSGTradingSessionStatusRequest = "g";

    public static final String MSGUserRequest = "BE";

    public static final String MSGUserResponse = "BF";

    public static final String MSGXMLMessage = "n";

    public static final String TAGAccount = "1";

    public static final String TAGAccountType = "581";

    public static final String TAGAccruedInterestAmt = "159";

    public static final String TAGAccruedInterestRate = "158";

    public static final String TAGAcctIDSource = "660";

    public static final String TAGAdjustment = "334";

    public static final String TAGAdjustmentType = "718";

    public static final String TAGAdvId = "2";

    public static final String TAGAdvRefID = "3";

    public static final String TAGAdvSide = "4";

    public static final String TAGAdvTransType = "5";

    public static final String TAGAffectedOrderID = "535";

    public static final String TAGAffectedSecondaryOrderID = "536";

    public static final String TAGAffirmStatus = "940";

    public static final String TAGAggregatedBook = "266";

    public static final String TAGAgreementCurrency = "918";

    public static final String TAGAgreementDate = "915";

    public static final String TAGAgreementDesc = "913";

    public static final String TAGAgreementID = "914";

    public static final String TAGAllocAccount = "79";

    public static final String TAGAllocAccountType = "798";

    public static final String TAGAllocAccruedInterestAmt = "742";

    public static final String TAGAllocAcctIDSource = "661";

    public static final String TAGAllocAvgPx = "153";

    public static final String TAGAllocCancReplaceReason = "796";

    public static final String TAGAllocHandlInst = "209";

    public static final String TAGAllocID = "70";

    public static final String TAGAllocInterestAtMaturity = "741";

    public static final String TAGAllocIntermedReqType = "808";

    public static final String TAGAllocLinkID = "196";

    public static final String TAGAllocLinkType = "197";

    public static final String TAGAllocNetMoney = "154";

    public static final String TAGAllocNoOrdersType = "857";

    public static final String TAGAllocPrice = "366";

    public static final String TAGAllocQty = "80";

    public static final String TAGAllocRejCode = "88";

    public static final String TAGAllocReportID = "755";

    public static final String TAGAllocReportRefID = "795";

    public static final String TAGAllocReportType = "794";

    public static final String TAGAllocSettlCurrAmt = "737";

    public static final String TAGAllocSettlCurrency = "736";

    public static final String TAGAllocSettlInstType = "780";

    public static final String TAGAllocShares = "80";

    public static final String TAGAllocStatus = "87";

    public static final String TAGAllocText = "161";

    public static final String TAGAllocTransType = "71";

    public static final String TAGAllocType = "626";

    public static final String TAGAllowableOneSidednessCurr = "767";

    public static final String TAGAllowableOneSidednessPct = "765";

    public static final String TAGAllowableOneSidednessValue = "766";

    public static final String TAGAltMDSourceID = "817";

    public static final String TAGApplQueueAction = "815";

    public static final String TAGApplQueueDepth = "813";

    public static final String TAGApplQueueMax = "812";

    public static final String TAGApplQueueResolution = "814";

    public static final String TAGAsgnReqID = "831";

    public static final String TAGAsgnRptID = "833";

    public static final String TAGAssignmentMethod = "744";

    public static final String TAGAssignmentUnit = "745";

    public static final String TAGAutoAcceptIndicator = "754";

    public static final String TAGAvgParPx = "860";

    public static final String TAGAvgPrxPrecision = "74";

    public static final String TAGAvgPx = "6";

    public static final String TAGAvgPxIndicator = "819";

    public static final String TAGAvgPxPrecision = "74";

    public static final String TAGBasisFeatureDate = "259";

    public static final String TAGBasisFeaturePrice = "260";

    public static final String TAGBasisPxType = "419";

    public static final String TAGBeginSeqNo = "7";

    public static final String TAGBeginString = "8";

    public static final String TAGBenchmark = "219";

    public static final String TAGBenchmarkCurveCurrency = "220";

    public static final String TAGBenchmarkCurveName = "221";

    public static final String TAGBenchmarkCurvePoint = "222";

    public static final String TAGBenchmarkPrice = "662";

    public static final String TAGBenchmarkPriceType = "663";

    public static final String TAGBenchmarkSecurityID = "699";

    public static final String TAGBenchmarkSecurityIDSource = "761";

    public static final String TAGBidDescriptor = "400";

    public static final String TAGBidDescriptorType = "399";

    public static final String TAGBidForwardPoints = "189";

    public static final String TAGBidForwardPoints2 = "642";

    public static final String TAGBidID = "390";

    public static final String TAGBidPx = "132";

    public static final String TAGBidRequestTransType = "374";

    public static final String TAGBidSize = "134";

    public static final String TAGBidSpotRate = "188";

    public static final String TAGBidTradeType = "418";

    public static final String TAGBidType = "394";

    public static final String TAGBidYield = "632";

    public static final String TAGBodyLength = "9";

    public static final String TAGBookingRefID = "466";

    public static final String TAGBookingType = "775";

    public static final String TAGBookingUnit = "590";

    public static final String TAGBrokerOfCredit = "92";

    public static final String TAGBusinessRejectReason = "380";

    public static final String TAGBusinessRejectRefID = "379";

    public static final String TAGBuyVolume = "330";

    public static final String TAGCancellationRights = "480";

    public static final String TAGCardExpDate = "490";

    public static final String TAGCardHolderName = "488";

    public static final String TAGCardIssNo = "491";

    public static final String TAGCardNumber = "489";

    public static final String TAGCardStartDate = "503";

    public static final String TAGCashDistribAgentAcctName = "502";

    public static final String TAGCashDistribAgentAcctNumber = "500";

    public static final String TAGCashDistribAgentCode = "499";

    public static final String TAGCashDistribAgentName = "498";

    public static final String TAGCashDistribCurr = "478";

    public static final String TAGCashDistribPayRef = "501";

    public static final String TAGCashMargin = "544";

    public static final String TAGCashOrderQty = "152";

    public static final String TAGCashOutstanding = "901";

    public static final String TAGCashSettlAgentAcctName = "185";

    public static final String TAGCashSettlAgentAcctNum = "184";

    public static final String TAGCashSettlAgentCode = "183";

    public static final String TAGCashSettlAgentContactName = "186";

    public static final String TAGCashSettlAgentContactPhone = "187";

    public static final String TAGCashSettlAgentName = "182";

    public static final String TAGCFICode = "461";

    public static final String TAGCheckSum = "10";

    public static final String TAGClearingAccount = "440";

    public static final String TAGClearingBusinessDate = "715";

    public static final String TAGClearingFeeIndicator = "635";

    public static final String TAGClearingFirm = "439";

    public static final String TAGClearingInstruction = "577";

    public static final String TAGClientBidID = "391";

    public static final String TAGClientID = "109";

    public static final String TAGClOrdID = "11";

    public static final String TAGClOrdLinkID = "583";

    public static final String TAGCollAction = "944";

    public static final String TAGCollAsgnID = "902";

    public static final String TAGCollAsgnReason = "895";

    public static final String TAGCollAsgnRefID = "907";

    public static final String TAGCollAsgnRejectReason = "906";

    public static final String TAGCollAsgnRespType = "905";

    public static final String TAGCollAsgnTransType = "903";

    public static final String TAGCollInquiryID = "909";

    public static final String TAGCollInquiryQualifier = "896";

    public static final String TAGCollReqID = "894";

    public static final String TAGCollRespID = "904";

    public static final String TAGCollRptID = "908";

    public static final String TAGCollStatus = "910";

    public static final String TAGCommCurrency = "479";

    public static final String TAGCommission = "12";

    public static final String TAGCommType = "13";

    public static final String TAGCompID = "930";

    public static final String TAGComplianceID = "376";

    public static final String TAGConcession = "238";

    public static final String TAGConfirmID = "664";

    public static final String TAGConfirmRefID = "772";

    public static final String TAGConfirmRejReason = "774";

    public static final String TAGConfirmReqID = "859";

    public static final String TAGConfirmStatus = "665";

    public static final String TAGConfirmTransType = "666";

    public static final String TAGConfirmType = "773";

    public static final String TAGContAmtCurr = "521";

    public static final String TAGContAmtType = "519";

    public static final String TAGContAmtValue = "520";

    public static final String TAGContraBroker = "375";

    public static final String TAGContractMultiplier = "231";

    public static final String TAGContractSettlMonth = "667";

    public static final String TAGContraLegRefID = "655";

    public static final String TAGContraryInstructionIndicator = "719";

    public static final String TAGContraTradeQty = "437";

    public static final String TAGContraTrader = "337";

    public static final String TAGContraTradeTime = "438";

    public static final String TAGCopyMsgIndicator = "797";

    public static final String TAGCorporateAction = "292";

    public static final String TAGCountry = "421";

    public static final String TAGCountryOfIssue = "470";

    public static final String TAGCouponPaymentDate = "224";

    public static final String TAGCouponRate = "223";

    public static final String TAGCoveredOrUncovered = "203";

    public static final String TAGCPProgram = "875";

    public static final String TAGCPRegType = "876";

    public static final String TAGCreditRating = "255";

    public static final String TAGCrossID = "548";

    public static final String TAGCrossPercent = "413";

    public static final String TAGCrossPrioritization = "550";

    public static final String TAGCrossType = "549";

    public static final String TAGCumQty = "14";

    public static final String TAGCurrency = "15";

    public static final String TAGCustomerOrFirm = "204";

    public static final String TAGCustOrderCapacity = "582";

    public static final String TAGCxlQty = "84";

    public static final String TAGCxlRejReason = "102";

    public static final String TAGCxlRejResponseTo = "434";

    public static final String TAGCxlType = "125";

    public static final String TAGDateOfBirth = "486";

    public static final String TAGDatedDate = "873";

    public static final String TAGDayAvgPx = "426";

    public static final String TAGDayBookingInst = "589";

    public static final String TAGDayCumQty = "425";

    public static final String TAGDayOrderQty = "424";

    public static final String TAGDefBidSize = "293";

    public static final String TAGDefOfferSize = "294";

    public static final String TAGDeleteReason = "285";

    public static final String TAGDeliverToCompID = "128";

    public static final String TAGDeliverToLocationID = "145";

    public static final String TAGDeliverToSubID = "129";

    public static final String TAGDeliveryDate = "743";

    public static final String TAGDeliveryForm = "668";

    public static final String TAGDesignation = "494";

    public static final String TAGDeskID = "284";

    public static final String TAGDiscretionInst = "388";

    public static final String TAGDiscretionLimitType = "843";

    public static final String TAGDiscretionMoveType = "841";

    public static final String TAGDiscretionOffset = "389";

    public static final String TAGDiscretionOffsetType = "842";

    public static final String TAGDiscretionOffsetValue = "389";

    public static final String TAGDiscretionPrice = "845";

    public static final String TAGDiscretionRoundDirection = "844";

    public static final String TAGDiscretionScope = "846";

    public static final String TAGDistribPaymentMethod = "477";

    public static final String TAGDistribPercentage = "512";

    public static final String TAGDKReason = "127";

    public static final String TAGDlvyInst = "86";

    public static final String TAGDlvyInstType = "787";

    public static final String TAGDueToRelated = "329";

    public static final String TAGEffectiveTime = "168";

    public static final String TAGEFPTrackingError = "405";

    public static final String TAGEmailThreadID = "164";

    public static final String TAGEmailType = "94";

    public static final String TAGEncodedAllocText = "361";

    public static final String TAGEncodedAllocTextLen = "360";

    public static final String TAGEncodedHeadline = "359";

    public static final String TAGEncodedHeadlineLen = "358";

    public static final String TAGEncodedIssuer = "349";

    public static final String TAGEncodedIssuerLen = "348";

    public static final String TAGEncodedLegIssuer = "619";

    public static final String TAGEncodedLegIssuerLen = "618";

    public static final String TAGEncodedLegSecurityDesc = "622";

    public static final String TAGEncodedLegSecurityDescLen = "621";

    public static final String TAGEncodedListExecInst = "353";

    public static final String TAGEncodedListExecInstLen = "352";

    public static final String TAGEncodedListStatusText = "446";

    public static final String TAGEncodedListStatusTextLen = "445";

    public static final String TAGEncodedSecurityDesc = "351";

    public static final String TAGEncodedSecurityDescLen = "350";

    public static final String TAGEncodedSubject = "357";

    public static final String TAGEncodedSubjectLen = "356";

    public static final String TAGEncodedText = "355";

    public static final String TAGEncodedTextLen = "354";

    public static final String TAGEncodedUnderlyingIssuer = "363";

    public static final String TAGEncodedUnderlyingIssuerLen = "362";

    public static final String TAGEncodedUnderlyingSecurityDesc = "365";

    public static final String TAGEncodedUnderlyingSecurityDescLen = "364";

    public static final String TAGEncryptMethod = "98";

    public static final String TAGEndAccruedInterestAmt = "920";

    public static final String TAGEndCash = "922";

    public static final String TAGEndDate = "917";

    public static final String TAGEndSeqNo = "16";

    public static final String TAGEventDate = "866";

    public static final String TAGEventPx = "867";

    public static final String TAGEventText = "868";

    public static final String TAGEventType = "865";

    public static final String TAGExchangeForPhysical = "411";

    public static final String TAGExchangeRule = "825";

    public static final String TAGExDate = "230";

    public static final String TAGExDestination = "100";

    public static final String TAGExecBroker = "76";

    public static final String TAGExecID = "17";

    public static final String TAGExecInst = "18";

    public static final String TAGExecPriceAdjustment = "485";

    public static final String TAGExecPriceType = "484";

    public static final String TAGExecRefID = "19";

    public static final String TAGExecRestatementReason = "378";

    public static final String TAGExecTransType = "20";

    public static final String TAGExecType = "150";

    public static final String TAGExecValuationPoint = "515";

    public static final String TAGExerciseMethod = "747";

    public static final String TAGExpirationCycle = "827";

    public static final String TAGExpireDate = "432";

    public static final String TAGExpireTime = "126";

    public static final String TAGFactor = "228";

    public static final String TAGFairValue = "406";

    public static final String TAGFinancialStatus = "291";

    public static final String TAGForexReq = "121";

    public static final String TAGFundRenewWaiv = "497";

    public static final String TAGFutSettDate = "64";

    public static final String TAGFutSettDate2 = "193";

    public static final String TAGGapFillFlag = "123";

    public static final String TAGGrossTradeAmt = "381";

    public static final String TAGGTBookingInst = "427";

    public static final String TAGHaltReason = "327";

    public static final String TAGHandlInst = "21";

    public static final String TAGHeadline = "148";

    public static final String TAGHeartBtInt = "108";

    public static final String TAGHighPx = "332";

    public static final String TAGHopCompID = "628";

    public static final String TAGHopRefID = "630";

    public static final String TAGHopSendingTime = "629";

    public static final String TAGIDSource = "22";

    public static final String TAGIncTaxInd = "416";

    public static final String TAGIndividualAllocID = "467";

    public static final String TAGIndividualAllocRejCode = "776";

    public static final String TAGInquiryResult = "946";

    public static final String TAGInquiryStatus = "945";

    public static final String TAGInstrAttribType = "871";

    public static final String TAGInstrAttribValue = "872";

    public static final String TAGInstrRegistry = "543";

    public static final String TAGInterestAccrualDate = "874";

    public static final String TAGInterestAtMaturity = "738";

    public static final String TAGInvestorCountryOfResidence = "475";

    public static final String TAGInViewOfCommon = "328";

    public static final String TAGIOIid = "23";

    public static final String TAGIOINaturalFlag = "130";

    public static final String TAGIOIOthSvc = "24";

    public static final String TAGIOIQltyInd = "25";

    public static final String TAGIOIQty = "27";

    public static final String TAGIOIQualifier = "104";

    public static final String TAGIOIRefID = "26";

    public static final String TAGIOIShares = "27";

    public static final String TAGIOITransType = "28";

    public static final String TAGIssueDate = "225";

    public static final String TAGIssuer = "106";

    public static final String TAGLastCapacity = "29";

    public static final String TAGLastForwardPoints = "195";

    public static final String TAGLastForwardPoints2 = "641";

    public static final String TAGLastFragment = "893";

    public static final String TAGLastLiquidityInd = "851";

    public static final String TAGLastMkt = "30";

    public static final String TAGLastMsgSeqNumProcessed = "369";

    public static final String TAGLastNetworkReponseID = "934";

    public static final String TAGLastParPx = "669";

    public static final String TAGLastPx = "31";

    public static final String TAGLastQty = "32";

    public static final String TAGLastRptRequested = "912";

    public static final String TAGLastShares = "32";

    public static final String TAGLastSpotRate = "194";

    public static final String TAGLastUpdateTime = "779";

    public static final String TAGLeavesQty = "151";

    public static final String TAGLegalConfirm = "650";

    public static final String TAGLegAllocAccount = "671";

    public static final String TAGLegAllocAcctIDSource = "674";

    public static final String TAGLegAllocQty = "673";

    public static final String TAGLegBenchmarkCurveCurrency = "676";

    public static final String TAGLegBenchmarkCurveName = "677";

    public static final String TAGLegBenchmarkCurvePoint = "678";

    public static final String TAGLegBenchmarkPrice = "679";

    public static final String TAGLegBenchmarkPriceType = "680";

    public static final String TAGLegBidPx = "681";

    public static final String TAGLegCFICode = "608";

    public static final String TAGLegContractMultiplier = "614";

    public static final String TAGLegCountryOfIssue = "596";

    public static final String TAGLegCouponPaymentDate = "248";

    public static final String TAGLegCouponRate = "615";

    public static final String TAGLegCoveredOrUncovered = "565";

    public static final String TAGLegCreditRating = "257";

    public static final String TAGLegCurrency = "556";

    public static final String TAGLegDeliveryForm = "739";

    public static final String TAGLegFactor = "253";

    public static final String TAGLegFutSettDate = "588";

    public static final String TAGLegIOIQty = "682";

    public static final String TAGLegIndividualAllocID = "672";

    public static final String TAGLegInstrRegistry = "599";

    public static final String TAGLegIssueDate = "249";

    public static final String TAGLegIssuer = "617";

    public static final String TAGLegLastPx = "637";

    public static final String TAGLegLocaleOfIssue = "598";

    public static final String TAGLegMaturityDate = "611";

    public static final String TAGLegMaturityMonthYear = "610";

    public static final String TAGLegOfferPx = "684";

    public static final String TAGLegOptAttribute = "613";

    public static final String TAGLegOrderQty = "685";

    public static final String TAGLegPool = "740";

    public static final String TAGLegPositionEffect = "564";

    public static final String TAGLegPrice = "566";

    public static final String TAGLegPriceType = "686";

    public static final String TAGLegProduct = "607";

    public static final String TAGLegQty = "687";

    public static final String TAGLegRatioQty = "623";

    public static final String TAGLegRedemptionDate = "254";

    public static final String TAGLegRefID = "654";

    public static final String TAGLegRepoCollateralSecurityType = "250";

    public static final String TAGLegRepurchaseRate = "252";

    public static final String TAGLegRepurchaseTerm = "251";

    public static final String TAGLegSecurityAltID = "605";

    public static final String TAGLegSecurityAltIDSource = "606";

    public static final String TAGLegSecurityDesc = "620";

    public static final String TAGLegSecurityExchange = "616";

    public static final String TAGLegSecurityID = "602";

    public static final String TAGLegSecurityIDSource = "603";

    public static final String TAGLegSecuritySubType = "764";

    public static final String TAGLegSecurityType = "609";

    public static final String TAGLegSettlCurrency = "675";

    public static final String TAGLegSettlDate = "588";

    public static final String TAGLegSettlType = "587";

    public static final String TAGLegSettlmntTyp = "587";

    public static final String TAGLegSide = "624";

    public static final String TAGLegStateOrProvinceOfIssue = "597";

    public static final String TAGLegStipulationType = "688";

    public static final String TAGLegStipulationValue = "689";

    public static final String TAGLegStrikeCurrency = "942";

    public static final String TAGLegStrikePrice = "612";

    public static final String TAGLegSwapType = "690";

    public static final String TAGLegSymbol = "600";

    public static final String TAGLegSymbolSfx = "601";

    public static final String TAGLinesOfText = "33";

    public static final String TAGLiquidityIndType = "409";

    public static final String TAGLiquidityNumSecurities = "441";

    public static final String TAGLiquidityPctHigh = "403";

    public static final String TAGLiquidityPctLow = "402";

    public static final String TAGLiquidityValue = "404";

    public static final String TAGListExecInst = "69";

    public static final String TAGListExecInstType = "433";

    public static final String TAGListID = "66";

    public static final String TAGListName = "392";

    public static final String TAGListNoOrds = "68";

    public static final String TAGListOrderStatus = "431";

    public static final String TAGListSeqNo = "67";

    public static final String TAGListStatusText = "444";

    public static final String TAGListStatusType = "429";

    public static final String TAGLocaleOfIssue = "472";

    public static final String TAGLocateReqd = "114";

    public static final String TAGLocationID = "283";

    public static final String TAGLongQty = "704";

    public static final String TAGLowPx = "333";

    public static final String TAGMailingDtls = "474";

    public static final String TAGMailingInst = "482";

    public static final String TAGMarginExcess = "899";

    public static final String TAGMarginRatio = "898";

    public static final String TAGMarketDepth = "264";

    public static final String TAGMassCancelRejectReason = "532";

    public static final String TAGMassCancelRequestType = "530";

    public static final String TAGMassCancelResponse = "531";

    public static final String TAGMassStatusReqID = "584";

    public static final String TAGMassStatusReqType = "585";

    public static final String TAGMatchStatus = "573";

    public static final String TAGMatchType = "574";

    public static final String TAGMaturityDate = "541";

    public static final String TAGMaturityDay = "205";

    public static final String TAGMaturityMonthYear = "200";

    public static final String TAGMaturityNetMoney = "890";

    public static final String TAGMaxFloor = "111";

    public static final String TAGMaxMessageSize = "383";

    public static final String TAGMaxShow = "210";

    public static final String TAGMDEntryBuyer = "288";

    public static final String TAGMDEntryDate = "272";

    public static final String TAGMDEntryID = "278";

    public static final String TAGMDEntryOriginator = "282";

    public static final String TAGMDEntryPositionNo = "290";

    public static final String TAGMDEntryPx = "270";

    public static final String TAGMDEntryRefID = "280";

    public static final String TAGMDEntrySeller = "289";

    public static final String TAGMDEntrySize = "271";

    public static final String TAGMDEntryTime = "273";

    public static final String TAGMDEntryType = "269";

    public static final String TAGMDImplicitDelete = "547";

    public static final String TAGMDMkt = "275";

    public static final String TAGMDReqID = "262";

    public static final String TAGMDReqRejReason = "281";

    public static final String TAGMDUpdateAction = "279";

    public static final String TAGMDUpdateType = "265";

    public static final String TAGMessageEncoding = "347";

    public static final String TAGMidPx = "631";

    public static final String TAGMidYield = "633";

    public static final String TAGMinBidSize = "647";

    public static final String TAGMinOfferSize = "648";

    public static final String TAGMinQty = "110";

    public static final String TAGMinTradeVol = "562";

    public static final String TAGMiscFeeAmt = "137";

    public static final String TAGMiscFeeBasis = "891";

    public static final String TAGMiscFeeCurr = "138";

    public static final String TAGMiscFeeType = "139";

    public static final String TAGMktBidPx = "645";

    public static final String TAGMktOfferPx = "646";

    public static final String TAGMoneyLaunderingStatus = "481";

    public static final String TAGMsgDirection = "385";

    public static final String TAGMsgSeqNum = "34";

    public static final String TAGMsgType = "35";

    public static final String TAGMultiLegReportingType = "442";

    public static final String TAGMultiLegRptTypeReq = "563";

    public static final String TAGNested2PartyID = "757";

    public static final String TAGNested2PartyIDSource = "758";

    public static final String TAGNested2PartyRole = "759";

    public static final String TAGNested2PartySubID = "760";

    public static final String TAGNested2PartySubIDType = "807";

    public static final String TAGNestedPartyID = "524";

    public static final String TAGNestedPartyIDSource = "525";

    public static final String TAGNestedPartyRole = "538";

    public static final String TAGNestedPartySubID = "545";

    public static final String TAGNestedPartySubIDType = "805";

    public static final String TAGNetChgPrevDay = "451";

    public static final String TAGNetGrossInd = "430";

    public static final String TAGNetMoney = "118";

    public static final String TAGNetworkRequestID = "933";

    public static final String TAGNetworkRequestType = "935";

    public static final String TAGNetworkResponseID = "932";

    public static final String TAGNetworkStatusResponseType = "937";

    public static final String TAGNewPassword = "925";

    public static final String TAGNewSeqNo = "36";

    public static final String TAGNextExpectedMsgSeqNum = "789";

    public static final String TAGNoAffectedOrders = "534";

    public static final String TAGNoAllocs = "78";

    public static final String TAGNoAltMDSource = "816";

    public static final String TAGNoBidComponents = "420";

    public static final String TAGNoBidDescriptors = "398";

    public static final String TAGNoCapacities = "862";

    public static final String TAGNoClearingInstructions = "576";

    public static final String TAGNoCollInquiryQualifier = "938";

    public static final String TAGNoCompIDs = "936";

    public static final String TAGNoContAmts = "518";

    public static final String TAGNoContraBrokers = "382";

    public static final String TAGNoDates = "580";

    public static final String TAGNoDistribInsts = "510";

    public static final String TAGNoDlvyInst = "85";

    public static final String TAGNoEvents = "864";

    public static final String TAGNoExecs = "124";

    public static final String TAGNoHops = "627";

    public static final String TAGNoIOIQualifiers = "199";

    public static final String TAGNoInstrAttrib = "870";

    public static final String TAGNoLegAllocs = "670";

    public static final String TAGNoLegs = "555";

    public static final String TAGNoLegSecurityAltID = "604";

    public static final String TAGNoLegStipulations = "683";

    public static final String TAGNoMDEntries = "268";

    public static final String TAGNoMDEntryTypes = "267";

    public static final String TAGNoMiscFees = "136";

    public static final String TAGNoMsgTypes = "384";

    public static final String TAGNoNested2PartyIDs = "756";

    public static final String TAGNoNested2PartySubIDs = "806";

    public static final String TAGNoNestedPartyIDs = "539";

    public static final String TAGNoNestedPartySubIDs = "804";

    public static final String TAGNoOrders = "73";

    public static final String TAGNoPartyIDs = "453";

    public static final String TAGNoPartySubIDs = "802";

    public static final String TAGNoPosAmt = "753";

    public static final String TAGNoPositions = "702";

    public static final String TAGNoQuoteEntries = "295";

    public static final String TAGNoQuoteQualifiers = "735";

    public static final String TAGNoQuoteSets = "296";

    public static final String TAGNoRegistDtls = "473";

    public static final String TAGNoRelatedSym = "146";

    public static final String TAGNoRoutingIDs = "215";

    public static final String TAGNoRpts = "82";

    public static final String TAGNoSecurityAltID = "454";

    public static final String TAGNoSecurityTypes = "558";

    public static final String TAGNoSettlInst = "778";

    public static final String TAGNoSettlPartyIDs = "781";

    public static final String TAGNoSettlPartySubIDs = "801";

    public static final String TAGNoSides = "552";

    public static final String TAGNoStipulations = "232";

    public static final String TAGNoStrikes = "428";

    public static final String TAGNotifyBrokerOfCredit = "208";

    public static final String TAGNoTrades = "897";

    public static final String TAGNoTradingSessions = "386";

    public static final String TAGNoTrdRegTimestamps = "768";

    public static final String TAGNoUnderlyingSecurityAltID = "457";

    public static final String TAGNoUnderlyingStips = "887";

    public static final String TAGNoUnderlyings = "711";

    public static final String TAGNumberOfOrders = "346";

    public static final String TAGNumBidders = "417";

    public static final String TAGNumDaysInterest = "157";

    public static final String TAGNumTickets = "395";

    public static final String TAGOddLot = "575";

    public static final String TAGOfferForwardPoints = "191";

    public static final String TAGOfferForwardPoints2 = "643";

    public static final String TAGOfferPx = "133";

    public static final String TAGOfferSize = "135";

    public static final String TAGOfferSpotRate = "190";

    public static final String TAGOfferYield = "634";

    public static final String TAGOnBehalfOfCompID = "115";

    public static final String TAGOnBehalfOfLocationID = "144";

    public static final String TAGOnBehalfOfSendingTime = "370";

    public static final String TAGOnBehalfOfSubID = "116";

    public static final String TAGOpenClose = "77";

    public static final String TAGOpenCloseSettlFlag = "286";

    public static final String TAGOpenCloseSettleFlag = "286";

    public static final String TAGOpenInterest = "746";

    public static final String TAGOptAttribute = "206";

    public static final String TAGOrderAvgPx = "799";

    public static final String TAGOrderBookingQty = "800";

    public static final String TAGOrderCapacity = "528";

    public static final String TAGOrderCapacityQty = "863";

    public static final String TAGOrderID = "37";

    public static final String TAGOrderInputDevice = "821";

    public static final String TAGOrderPercent = "516";

    public static final String TAGOrderQty = "38";

    public static final String TAGOrderQty2 = "192";

    public static final String TAGOrderRestrictions = "529";

    public static final String TAGOrdRejReason = "103";

    public static final String TAGOrdStatus = "39";

    public static final String TAGOrdStatusReqID = "790";

    public static final String TAGOrdType = "40";

    public static final String TAGOrigClOrdID = "41";

    public static final String TAGOrigCrossID = "551";

    public static final String TAGOrigOrdModTime = "586";

    public static final String TAGOrigPosReqRefID = "713";

    public static final String TAGOrigSendingTime = "122";

    public static final String TAGOrigTime = "42";

    public static final String TAGOutMainCntryUIndex = "412";

    public static final String TAGOutsideIndexPct = "407";

    public static final String TAGOwnershipType = "517";

    public static final String TAGOwnerType = "522";

    public static final String TAGParticipationRate = "849";

    public static final String TAGPartyID = "448";

    public static final String TAGPartyIDSource = "447";

    public static final String TAGPartyRole = "452";

    public static final String TAGPartySubID = "523";

    public static final String TAGPartySubIDType = "803";

    public static final String TAGPassword = "554";

    public static final String TAGPaymentDate = "504";

    public static final String TAGPaymentMethod = "492";

    public static final String TAGPaymentRef = "476";

    public static final String TAGPaymentRemitterID = "505";

    public static final String TAGPctAtRisk = "869";

    public static final String TAGPegDifference = "211";

    public static final String TAGPegLimitType = "837";

    public static final String TAGPegMoveType = "835";

    public static final String TAGPegOffsetType = "836";

    public static final String TAGPegOffsetValue = "211";

    public static final String TAGPegRoundDirection = "838";

    public static final String TAGPegScope = "840";

    public static final String TAGPeggedPrice = "839";

    public static final String TAGPool = "691";

    public static final String TAGPosAmt = "708";

    public static final String TAGPosAmtType = "707";

    public static final String TAGPosMaintAction = "712";

    public static final String TAGPosMaintResult = "723";

    public static final String TAGPosMaintRptID = "721";

    public static final String TAGPosMaintRptRefID = "714";

    public static final String TAGPosMaintStatus = "722";

    public static final String TAGPosQtyStatus = "706";

    public static final String TAGPosReqID = "710";

    public static final String TAGPosReqResult = "728";

    public static final String TAGPosReqStatus = "729";

    public static final String TAGPosReqType = "724";

    public static final String TAGPosTransType = "709";

    public static final String TAGPosType = "703";

    public static final String TAGPositionEffect = "77";

    public static final String TAGPossDupFlag = "43";

    public static final String TAGPossResend = "97";

    public static final String TAGPreallocMethod = "591";

    public static final String TAGPrevClosePx = "140";

    public static final String TAGPreviouslyReported = "570";

    public static final String TAGPrice = "44";

    public static final String TAGPrice2 = "640";

    public static final String TAGPriceDelta = "811";

    public static final String TAGPriceImprovement = "639";

    public static final String TAGPriceType = "423";

    public static final String TAGPriorSettlPrice = "734";

    public static final String TAGPriorSpreadIndicator = "720";

    public static final String TAGPriorityIndicator = "638";

    public static final String TAGProcessCode = "81";

    public static final String TAGProduct = "460";

    public static final String TAGProgPeriodInterval = "415";

    public static final String TAGProgRptReqs = "414";

    public static final String TAGPublishTrdIndicator = "852";

    public static final String TAGPutOrCall = "201";

    public static final String TAGQtyType = "854";

    public static final String TAGQuantity = "53";

    public static final String TAGQuantityType = "465";

    public static final String TAGQuoteAckStatus = "297";

    public static final String TAGQuoteCancelType = "298";

    public static final String TAGQuoteCondition = "276";

    public static final String TAGQuoteEntryID = "299";

    public static final String TAGQuoteEntryRejectReason = "368";

    public static final String TAGQuoteID = "117";

    public static final String TAGQuotePriceType = "692";

    public static final String TAGQuoteQualifier = "695";

    public static final String TAGQuoteRejectReason = "300";

    public static final String TAGQuoteReqID = "131";

    public static final String TAGQuoteRequestRejectReason = "658";

    public static final String TAGQuoteRequestType = "303";

    public static final String TAGQuoteRespID = "693";

    public static final String TAGQuoteRespType = "694";

    public static final String TAGQuoteResponseLevel = "301";

    public static final String TAGQuoteSetID = "302";

    public static final String TAGQuoteSetValidUntilTime = "367";

    public static final String TAGQuoteStatus = "297";

    public static final String TAGQuoteStatusReqID = "649";

    public static final String TAGQuoteType = "537";

    public static final String TAGRatioQty = "319";

    public static final String TAGRawData = "96";

    public static final String TAGRawDataLength = "95";

    public static final String TAGRedemptionDate = "240";

    public static final String TAGRefAllocID = "72";

    public static final String TAGRefMsgType = "372";

    public static final String TAGRefSeqNum = "45";

    public static final String TAGRefTagID = "371";

    public static final String TAGRegistAcctType = "493";

    public static final String TAGRegistDetls = "509";

    public static final String TAGRegistEmail = "511";

    public static final String TAGRegistID = "513";

    public static final String TAGRegistRefID = "508";

    public static final String TAGRegistRejReasonCode = "507";

    public static final String TAGRegistRejReasonText = "496";

    public static final String TAGRegistStatus = "506";

    public static final String TAGRegistTransType = "514";

    public static final String TAGRelatdSym = "46";

    public static final String TAGRepoCollateralSecurityType = "239";

    public static final String TAGReportToExch = "113";

    public static final String TAGReportedPx = "861";

    public static final String TAGRepurchaseRate = "227";

    public static final String TAGRepurchaseTerm = "226";

    public static final String TAGResetSeqNumFlag = "141";

    public static final String TAGResponseDestination = "726";

    public static final String TAGResponseTransportType = "725";

    public static final String TAGReversalIndicator = "700";

    public static final String TAGRFQReqID = "644";

    public static final String TAGRoundingDirection = "468";

    public static final String TAGRoundingModulus = "469";

    public static final String TAGRoundLot = "561";

    public static final String TAGRoutingID = "217";

    public static final String TAGRoutingType = "216";

    public static final String TAGRptSeq = "83";

    public static final String TAGRule80A = "47";

    public static final String TAGScope = "546";

    public static final String TAGSecDefStatus = "653";

    public static final String TAGSecondaryAllocID = "793";

    public static final String TAGSecondaryClOrdID = "526";

    public static final String TAGSecondaryExecID = "527";

    public static final String TAGSecondaryOrderID = "198";

    public static final String TAGSecondaryTradeReportID = "818";

    public static final String TAGSecondaryTradeReportRefID = "881";

    public static final String TAGSecondaryTrdType = "855";

    public static final String TAGSecureData = "91";

    public static final String TAGSecureDataLen = "90";

    public static final String TAGSecurityAltID = "455";

    public static final String TAGSecurityAltIDSource = "456";

    public static final String TAGSecurityDesc = "107";

    public static final String TAGSecurityExchange = "207";

    public static final String TAGSecurityID = "48";

    public static final String TAGSecurityIDSource = "22";

    public static final String TAGSecurityListRequestType = "559";

    public static final String TAGSecurityReqID = "320";

    public static final String TAGSecurityRequestResult = "560";

    public static final String TAGSecurityRequestType = "321";

    public static final String TAGSecurityResponseID = "322";

    public static final String TAGSecurityResponseType = "323";

    public static final String TAGSecuritySettlAgentAcctName = "179";

    public static final String TAGSecuritySettlAgentAcctNum = "178";

    public static final String TAGSecuritySettlAgentCode = "177";

    public static final String TAGSecuritySettlAgentContactName = "180";

    public static final String TAGSecuritySettlAgentContactPhone = "181";

    public static final String TAGSecuritySettlAgentName = "176";

    public static final String TAGSecurityStatusReqID = "324";

    public static final String TAGSecuritySubType = "762";

    public static final String TAGSecurityTradingStatus = "326";

    public static final String TAGSecurityType = "167";

    public static final String TAGSellerDays = "287";

    public static final String TAGSellVolume = "331";

    public static final String TAGSenderCompID = "49";

    public static final String TAGSenderLocationID = "142";

    public static final String TAGSenderSubID = "50";

    public static final String TAGSendingDate = "51";

    public static final String TAGSendingTime = "52";

    public static final String TAGSessionRejectReason = "373";

    public static final String TAGSettlBrkrCode = "174";

    public static final String TAGSettlCurrAmt = "119";

    public static final String TAGSettlCurrBidFxRate = "656";

    public static final String TAGSettlCurrency = "120";

    public static final String TAGSettlCurrFxRate = "155";

    public static final String TAGSettlCurrFxRateCalc = "156";

    public static final String TAGSettlCurrOfferFxRate = "657";

    public static final String TAGSettlDate = "64";

    public static final String TAGSettlDate2 = "193";

    public static final String TAGSettlDeliveryType = "172";

    public static final String TAGSettlDepositoryCode = "173";

    public static final String TAGSettlInstCode = "175";

    public static final String TAGSettlInstID = "162";

    public static final String TAGSettlInstMode = "160";

    public static final String TAGSettlInstMsgID = "777";

    public static final String TAGSettlInstRefID = "214";

    public static final String TAGSettlInstReqID = "791";

    public static final String TAGSettlInstReqRejCode = "792";

    public static final String TAGSettlInstSource = "165";

    public static final String TAGSettlInstTransType = "163";

    public static final String TAGSettlLocation = "166";

    public static final String TAGSettlPartyID = "782";

    public static final String TAGSettlPartyIDSource = "783";

    public static final String TAGSettlPartyRole = "784";

    public static final String TAGSettlPartySubID = "785";

    public static final String TAGSettlPartySubIDType = "786";

    public static final String TAGSettlPrice = "730";

    public static final String TAGSettlPriceType = "731";

    public static final String TAGSettlSessID = "716";

    public static final String TAGSettlSessSubID = "717";

    public static final String TAGSettlType = "63";

    public static final String TAGSettlmntTyp = "63";

    public static final String TAGSharedCommission = "858";

    public static final String TAGShares = "53";

    public static final String TAGShortQty = "705";

    public static final String TAGShortSaleReason = "853";

    public static final String TAGSide = "54";

    public static final String TAGSideComplianceID = "659";

    public static final String TAGSideMultilegReportingType = "752";

    public static final String TAGSideValue1 = "396";

    public static final String TAGSideValue2 = "397";

    public static final String TAGSideValueInd = "401";

    public static final String TAGSignature = "89";

    public static final String TAGSignatureLength = "93";

    public static final String TAGSolicitedFlag = "377";

    public static final String TAGSpread = "218";

    public static final String TAGSpreadToBenchmark = "218";

    public static final String TAGStandInstDbID = "171";

    public static final String TAGStandInstDbName = "170";

    public static final String TAGStandInstDbType = "169";

    public static final String TAGStartCash = "921";

    public static final String TAGStartDate = "916";

    public static final String TAGStateOrProvinceOfIssue = "471";

    public static final String TAGStatusText = "929";

    public static final String TAGStatusValue = "928";

    public static final String TAGStipulationType = "233";

    public static final String TAGStipulationValue = "234";

    public static final String TAGStopPx = "99";

    public static final String TAGStrikeCurrency = "919";

    public static final String TAGStrikePrice = "202";

    public static final String TAGStrikeTime = "443";

    public static final String TAGSubID = "931";

    public static final String TAGSubject = "147";

    public static final String TAGSubscriptionRequestType = "263";

    public static final String TAGSymbol = "55";

    public static final String TAGSymbolSfx = "65";

    public static final String TAGTargetCompID = "56";

    public static final String TAGTargetLocationID = "143";

    public static final String TAGTargetStrategy = "847";

    public static final String TAGTargetStrategyParameters = "848";

    public static final String TAGTargetStrategyPerformance = "850";

    public static final String TAGTargetSubID = "57";

    public static final String TAGTaxAdvantageType = "495";

    public static final String TAGTerminationType = "788";

    public static final String TAGTestMessageIndicator = "464";

    public static final String TAGTestReqID = "112";

    public static final String TAGText = "58";

    public static final String TAGThresholdAmount = "834";

    public static final String TAGTickDirection = "274";

    public static final String TAGTimeBracket = "943";

    public static final String TAGTimeInForce = "59";

    public static final String TAGTotalAccruedInterestAmt = "540";

    public static final String TAGTotalAffectedOrders = "533";

    public static final String TAGTotalNetValue = "900";

    public static final String TAGTotalNumPosReports = "727";

    public static final String TAGTotalNumSecurities = "393";

    public static final String TAGTotalNumSecurityTypes = "557";

    public static final String TAGTotalTakedown = "237";

    public static final String TAGTotalVolumeTraded = "387";

    public static final String TAGTotalVolumeTradedDate = "449";

    public static final String TAGTotalVolumeTradedTime = "450";

    public static final String TAGTotNoAllocs = "892";

    public static final String TAGTotNoOrders = "68";

    public static final String TAGTotNoQuoteEntries = "304";

    public static final String TAGTotNoRelatedSym = "393";

    public static final String TAGTotNoStrikes = "422";

    public static final String TAGTotNumAssignmentReports = "832";

    public static final String TAGTotNumReports = "911";

    public static final String TAGTotNumSecurityTypes = "557";

    public static final String TAGTotNumTradeReports = "748";

    public static final String TAGTotQuoteEntries = "304";

    public static final String TAGTradeAllocIndicator = "826";

    public static final String TAGTradeCondition = "277";

    public static final String TAGTradeDate = "75";

    public static final String TAGTradedFlatSwitch = "258";

    public static final String TAGTradeInputDevice = "579";

    public static final String TAGTradeInputSource = "578";

    public static final String TAGTradeLegRefID = "824";

    public static final String TAGTradeLinkID = "820";

    public static final String TAGTradeOriginationDate = "229";

    public static final String TAGTradeReportID = "571";

    public static final String TAGTradeReportRefID = "572";

    public static final String TAGTradeReportRejectReason = "751";

    public static final String TAGTradeReportTransType = "487";

    public static final String TAGTradeReportType = "856";

    public static final String TAGTradeRequestID = "568";

    public static final String TAGTradeRequestResult = "749";

    public static final String TAGTradeRequestStatus = "750";

    public static final String TAGTradeRequestType = "569";

    public static final String TAGTradeType = "418";

    public static final String TAGTradingSessionID = "336";

    public static final String TAGTradingSessionSubID = "625";

    public static final String TAGTradSesCloseTime = "344";

    public static final String TAGTradSesEndTime = "345";

    public static final String TAGTradSesMethod = "338";

    public static final String TAGTradSesMode = "339";

    public static final String TAGTradSesOpenTime = "342";

    public static final String TAGTradSesPreCloseTime = "343";

    public static final String TAGTradSesReqID = "335";

    public static final String TAGTradSesStartTime = "341";

    public static final String TAGTradSesStatus = "340";

    public static final String TAGTradSesStatusRejReason = "567";

    public static final String TAGTransactTime = "60";

    public static final String TAGTransBkdTime = "483";

    public static final String TAGTransferReason = "830";

    public static final String TAGTrdMatchID = "880";

    public static final String TAGTrdRegTimestamp = "769";

    public static final String TAGTrdRegTimestampOrigin = "771";

    public static final String TAGTrdRegTimestampType = "770";

    public static final String TAGTrdRptStatus = "939";

    public static final String TAGTrdSubType = "829";

    public static final String TAGTrdType = "828";

    public static final String TAGUnderlyingCFICode = "463";

    public static final String TAGUnderlyingCPProgram = "877";

    public static final String TAGUnderlyingCPRegType = "878";

    public static final String TAGUnderlyingContractMultiplier = "436";

    public static final String TAGUnderlyingCountryOfIssue = "592";

    public static final String TAGUnderlyingCouponPaymentDate = "241";

    public static final String TAGUnderlyingCouponRate = "435";

    public static final String TAGUnderlyingCreditRating = "256";

    public static final String TAGUnderlyingCurrency = "318";

    public static final String TAGUnderlyingCurrentValue = "885";

    public static final String TAGUnderlyingDirtyPrice = "882";

    public static final String TAGUnderlyingEndPrice = "883";

    public static final String TAGUnderlyingEndValue = "886";

    public static final String TAGUnderlyingFactor = "246";

    public static final String TAGUnderlyingIDSource = "305";

    public static final String TAGUnderlyingInstrRegistry = "595";

    public static final String TAGUnderlyingIssueDate = "242";

    public static final String TAGUnderlyingIssuer = "306";

    public static final String TAGUnderlyingLastPx = "651";

    public static final String TAGUnderlyingLastQty = "652";

    public static final String TAGUnderlyingLocaleOfIssue = "594";

    public static final String TAGUnderlyingMaturityDate = "542";

    public static final String TAGUnderlyingMaturityDay = "314";

    public static final String TAGUnderlyingMaturityMonthYear = "313";

    public static final String TAGUnderlyingOptAttribute = "317";

    public static final String TAGUnderlyingProduct = "462";

    public static final String TAGUnderlyingPutOrCall = "315";

    public static final String TAGUnderlyingPx = "810";

    public static final String TAGUnderlyingQty = "879";

    public static final String TAGUnderlyingRedemptionDate = "247";

    public static final String TAGUnderlyingRepoCollateralSecurityType = "243";

    public static final String TAGUnderlyingRepurchaseRate = "245";

    public static final String TAGUnderlyingRepurchaseTerm = "244";

    public static final String TAGUnderlyingSecurityAltID = "458";

    public static final String TAGUnderlyingSecurityAltIDSource = "459";

    public static final String TAGUnderlyingSecurityDesc = "307";

    public static final String TAGUnderlyingSecurityExchange = "308";

    public static final String TAGUnderlyingSecurityID = "309";

    public static final String TAGUnderlyingSecurityIDSource = "305";

    public static final String TAGUnderlyingSecuritySubType = "763";

    public static final String TAGUnderlyingSecurityType = "310";

    public static final String TAGUnderlyingSettlPrice = "732";

    public static final String TAGUnderlyingSettlPriceType = "733";

    public static final String TAGUnderlyingStartValue = "884";

    public static final String TAGUnderlyingStateOrProvinceOfIssue = "593";

    public static final String TAGUnderlyingStipType = "888";

    public static final String TAGUnderlyingStipValue = "889";

    public static final String TAGUnderlyingStrikeCurrency = "941";

    public static final String TAGUnderlyingStrikePrice = "316";

    public static final String TAGUnderlyingSymbol = "311";

    public static final String TAGUnderlyingSymbolSfx = "312";

    public static final String TAGUnderlyingTradingSessionID = "822";

    public static final String TAGUnderlyingTradingSessionSubID = "823";

    public static final String TAGUnsolicitedIndicator = "325";

    public static final String TAGUrgency = "61";

    public static final String TAGURLLink = "149";

    public static final String TAGUserRequestID = "923";

    public static final String TAGUserRequestType = "924";

    public static final String TAGUserStatus = "926";

    public static final String TAGUserStatusText = "927";

    public static final String TAGUsername = "553";

    public static final String TAGValidUntilTime = "62";

    public static final String TAGValueOfFutures = "408";

    public static final String TAGWaveNo = "105";

    public static final String TAGWorkingIndicator = "636";

    public static final String TAGWtAverageLiquidity = "410";

    public static final String TAGXmlData = "213";

    public static final String TAGXmlDataLen = "212";

    public static final String TAGYield = "236";

    public static final String TAGYieldCalcDate = "701";

    public static final String TAGYieldRedemptionDate = "696";

    public static final String TAGYieldRedemptionPrice = "697";

    public static final String TAGYieldRedemptionPriceType = "698";

    public static final String TAGYieldType = "235";

    public static final int TAGiAccount = 1;

    public static final int TAGiAccountType = 581;

    public static final int TAGiAccruedInterestAmt = 159;

    public static final int TAGiAccruedInterestRate = 158;

    public static final int TAGiAcctIDSource = 660;

    public static final int TAGiAdjustment = 334;

    public static final int TAGiAdjustmentType = 718;

    public static final int TAGiAdvId = 2;

    public static final int TAGiAdvRefID = 3;

    public static final int TAGiAdvSide = 4;

    public static final int TAGiAdvTransType = 5;

    public static final int TAGiFixVersion = 8;

    public static final int TAGiAffectedOrderID = 535;

    public static final int TAGiAffectedSecondaryOrderID = 536;

    public static final int TAGiAffirmStatus = 940;

    public static final int TAGiAggregatedBook = 266;

    public static final int TAGiAgreementCurrency = 918;

    public static final int TAGiAgreementDate = 915;

    public static final int TAGiAgreementDesc = 913;

    public static final int TAGiAgreementID = 914;

    public static final int TAGiAllocAccount = 79;

    public static final int TAGiAllocAccountType = 798;

    public static final int TAGiAllocAccruedInterestAmt = 742;

    public static final int TAGiAllocAcctIDSource = 661;

    public static final int TAGiAllocAvgPx = 153;

    public static final int TAGiAllocCancReplaceReason = 796;

    public static final int TAGiAllocHandlInst = 209;

    public static final int TAGiAllocID = 70;

    public static final int TAGiAllocInterestAtMaturity = 741;

    public static final int TAGiAllocIntermedReqType = 808;

    public static final int TAGiAllocLinkID = 196;

    public static final int TAGiAllocLinkType = 197;

    public static final int TAGiAllocNetMoney = 154;

    public static final int TAGiAllocNoOrdersType = 857;

    public static final int TAGiAllocPrice = 366;

    public static final int TAGiAllocQty = 80;

    public static final int TAGiAllocRejCode = 88;

    public static final int TAGiAllocReportID = 755;

    public static final int TAGiAllocReportRefID = 795;

    public static final int TAGiAllocReportType = 794;

    public static final int TAGiAllocSettlCurrAmt = 737;

    public static final int TAGiAllocSettlCurrency = 736;

    public static final int TAGiAllocSettlInstType = 780;

    public static final int TAGiAllocShares = 80;

    public static final int TAGiAllocStatus = 87;

    public static final int TAGiAllocText = 161;

    public static final int TAGiAllocTransType = 71;

    public static final int TAGiAllocType = 626;

    public static final int TAGiAllowableOneSidednessCurr = 767;

    public static final int TAGiAllowableOneSidednessPct = 765;

    public static final int TAGiAllowableOneSidednessValue = 766;

    public static final int TAGiAltMDSourceID = 817;

    public static final int TAGiApplQueueAction = 815;

    public static final int TAGiApplQueueDepth = 813;

    public static final int TAGiApplQueueMax = 812;

    public static final int TAGiApplQueueResolution = 814;

    public static final int TAGiAsgnReqID = 831;

    public static final int TAGiAsgnRptID = 833;

    public static final int TAGiAssignmentMethod = 744;

    public static final int TAGiAssignmentUnit = 745;

    public static final int TAGiAutoAcceptIndicator = 754;

    public static final int TAGiAvgParPx = 860;

    public static final int TAGiAvgPrxPrecision = 74;

    public static final int TAGiAvgPx = 6;

    public static final int TAGiAvgPxIndicator = 819;

    public static final int TAGiAvgPxPrecision = 74;

    public static final int TAGiBasisFeatureDate = 259;

    public static final int TAGiBasisFeaturePrice = 260;

    public static final int TAGiBasisPxType = 419;

    public static final int TAGiBeginSeqNo = 7;

    public static final int TAGiBeginString = 8;

    public static final int TAGiBenchmark = 219;

    public static final int TAGiBenchmarkCurveCurrency = 220;

    public static final int TAGiBenchmarkCurveName = 221;

    public static final int TAGiBenchmarkCurvePoint = 222;

    public static final int TAGiBenchmarkPrice = 662;

    public static final int TAGiBenchmarkPriceType = 663;

    public static final int TAGiBenchmarkSecurityID = 699;

    public static final int TAGiBenchmarkSecurityIDSource = 761;

    public static final int TAGiBidDescriptor = 400;

    public static final int TAGiBidDescriptorType = 399;

    public static final int TAGiBidForwardPoints = 189;

    public static final int TAGiBidForwardPoints2 = 642;

    public static final int TAGiBidID = 390;

    public static final int TAGiBidPx = 132;

    public static final int TAGiBidRequestTransType = 374;

    public static final int TAGiBidSize = 134;

    public static final int TAGiBidSpotRate = 188;

    public static final int TAGiBidTradeType = 418;

    public static final int TAGiBidType = 394;

    public static final int TAGiBidYield = 632;

    public static final int TAGiBodyLength = 9;

    public static final int TAGiBookingRefID = 466;

    public static final int TAGiBookingType = 775;

    public static final int TAGiBookingUnit = 590;

    public static final int TAGiBrokerOfCredit = 92;

    public static final int TAGiBusinessRejectReason = 380;

    public static final int TAGiBusinessRejectRefID = 379;

    public static final int TAGiBuyVolume = 330;

    public static final int TAGiCancellationRights = 480;

    public static final int TAGiCardExpDate = 490;

    public static final int TAGiCardHolderName = 488;

    public static final int TAGiCardIssNo = 491;

    public static final int TAGiCardNumber = 489;

    public static final int TAGiCardStartDate = 503;

    public static final int TAGiCashDistribAgentAcctName = 502;

    public static final int TAGiCashDistribAgentAcctNumber = 500;

    public static final int TAGiCashDistribAgentCode = 499;

    public static final int TAGiCashDistribAgentName = 498;

    public static final int TAGiCashDistribCurr = 478;

    public static final int TAGiCashDistribPayRef = 501;

    public static final int TAGiCashMargin = 544;

    public static final int TAGiCashOrderQty = 152;

    public static final int TAGiCashOutstanding = 901;

    public static final int TAGiCashSettlAgentAcctName = 185;

    public static final int TAGiCashSettlAgentAcctNum = 184;

    public static final int TAGiCashSettlAgentCode = 183;

    public static final int TAGiCashSettlAgentContactName = 186;

    public static final int TAGiCashSettlAgentContactPhone = 187;

    public static final int TAGiCashSettlAgentName = 182;

    public static final int TAGiCFICode = 461;

    public static final int TAGiCheckSum = 10;

    public static final int TAGiClearingAccount = 440;

    public static final int TAGiClearingBusinessDate = 715;

    public static final int TAGiClearingFeeIndicator = 635;

    public static final int TAGiClearingFirm = 439;

    public static final int TAGiClearingInstruction = 577;

    public static final int TAGiClientBidID = 391;

    public static final int TAGiClientID = 109;

    public static final int TAGiClOrdID = 11;

    public static final int TAGiClOrdLinkID = 583;

    public static final int TAGiCollAction = 944;

    public static final int TAGiCollAsgnID = 902;

    public static final int TAGiCollAsgnReason = 895;

    public static final int TAGiCollAsgnRefID = 907;

    public static final int TAGiCollAsgnRejectReason = 906;

    public static final int TAGiCollAsgnRespType = 905;

    public static final int TAGiCollAsgnTransType = 903;

    public static final int TAGiCollInquiryID = 909;

    public static final int TAGiCollInquiryQualifier = 896;

    public static final int TAGiCollReqID = 894;

    public static final int TAGiCollRespID = 904;

    public static final int TAGiCollRptID = 908;

    public static final int TAGiCollStatus = 910;

    public static final int TAGiCommCurrency = 479;

    public static final int TAGiCommission = 12;

    public static final int TAGiCommType = 13;

    public static final int TAGiCompID = 930;

    public static final int TAGiComplianceID = 376;

    public static final int TAGiConcession = 238;

    public static final int TAGiConfirmID = 664;

    public static final int TAGiConfirmRefID = 772;

    public static final int TAGiConfirmRejReason = 774;

    public static final int TAGiConfirmReqID = 859;

    public static final int TAGiConfirmStatus = 665;

    public static final int TAGiConfirmTransType = 666;

    public static final int TAGiConfirmType = 773;

    public static final int TAGiContAmtCurr = 521;

    public static final int TAGiContAmtType = 519;

    public static final int TAGiContAmtValue = 520;

    public static final int TAGiContraBroker = 375;

    public static final int TAGiContractMultiplier = 231;

    public static final int TAGiContractSettlMonth = 667;

    public static final int TAGiContraLegRefID = 655;

    public static final int TAGiContraryInstructionIndicator = 719;

    public static final int TAGiContraTradeQty = 437;

    public static final int TAGiContraTrader = 337;

    public static final int TAGiContraTradeTime = 438;

    public static final int TAGiCopyMsgIndicator = 797;

    public static final int TAGiCorporateAction = 292;

    public static final int TAGiCountry = 421;

    public static final int TAGiCountryOfIssue = 470;

    public static final int TAGiCouponPaymentDate = 224;

    public static final int TAGiCouponRate = 223;

    public static final int TAGiCoveredOrUncovered = 203;

    public static final int TAGiCPProgram = 875;

    public static final int TAGiCPRegType = 876;

    public static final int TAGiCreditRating = 255;

    public static final int TAGiCrossID = 548;

    public static final int TAGiCrossPercent = 413;

    public static final int TAGiCrossPrioritization = 550;

    public static final int TAGiCrossType = 549;

    public static final int TAGiCumQty = 14;

    public static final int TAGiCurrency = 15;

    public static final int TAGiCustomerOrFirm = 204;

    public static final int TAGiCustOrderCapacity = 582;

    public static final int TAGiCxlQty = 84;

    public static final int TAGiCxlRejReason = 102;

    public static final int TAGiCxlRejResponseTo = 434;

    public static final int TAGiCxlType = 125;

    public static final int TAGiDateOfBirth = 486;

    public static final int TAGiDatedDate = 873;

    public static final int TAGiDayAvgPx = 426;

    public static final int TAGiDayBookingInst = 589;

    public static final int TAGiDayCumQty = 425;

    public static final int TAGiDayOrderQty = 424;

    public static final int TAGiDefBidSize = 293;

    public static final int TAGiDefOfferSize = 294;

    public static final int TAGiDeleteReason = 285;

    public static final int TAGiDeliverToCompID = 128;

    public static final int TAGiDeliverToLocationID = 145;

    public static final int TAGiDeliverToSubID = 129;

    public static final int TAGiDeliveryDate = 743;

    public static final int TAGiDeliveryForm = 668;

    public static final int TAGiDesignation = 494;

    public static final int TAGiDeskID = 284;

    public static final int TAGiDiscretionInst = 388;

    public static final int TAGiDiscretionLimitType = 843;

    public static final int TAGiDiscretionMoveType = 841;

    public static final int TAGiDiscretionOffset = 389;

    public static final int TAGiDiscretionOffsetType = 842;

    public static final int TAGiDiscretionOffsetValue = 389;

    public static final int TAGiDiscretionPrice = 845;

    public static final int TAGiDiscretionRoundDirection = 844;

    public static final int TAGiDiscretionScope = 846;

    public static final int TAGiDistribPaymentMethod = 477;

    public static final int TAGiDistribPercentage = 512;

    public static final int TAGiDKReason = 127;

    public static final int TAGiDlvyInst = 86;

    public static final int TAGiDlvyInstType = 787;

    public static final int TAGiDueToRelated = 329;

    public static final int TAGiEffectiveTime = 168;

    public static final int TAGiEFPTrackingError = 405;

    public static final int TAGiEmailThreadID = 164;

    public static final int TAGiEmailType = 94;

    public static final int TAGiEncodedAllocText = 361;

    public static final int TAGiEncodedAllocTextLen = 360;

    public static final int TAGiEncodedHeadline = 359;

    public static final int TAGiEncodedHeadlineLen = 358;

    public static final int TAGiEncodedIssuer = 349;

    public static final int TAGiEncodedIssuerLen = 348;

    public static final int TAGiEncodedLegIssuer = 619;

    public static final int TAGiEncodedLegIssuerLen = 618;

    public static final int TAGiEncodedLegSecurityDesc = 622;

    public static final int TAGiEncodedLegSecurityDescLen = 621;

    public static final int TAGiEncodedListExecInst = 353;

    public static final int TAGiEncodedListExecInstLen = 352;

    public static final int TAGiEncodedListStatusText = 446;

    public static final int TAGiEncodedListStatusTextLen = 445;

    public static final int TAGiEncodedSecurityDesc = 351;

    public static final int TAGiEncodedSecurityDescLen = 350;

    public static final int TAGiEncodedSubject = 357;

    public static final int TAGiEncodedSubjectLen = 356;

    public static final int TAGiEncodedText = 355;

    public static final int TAGiEncodedTextLen = 354;

    public static final int TAGiEncodedUnderlyingIssuer = 363;

    public static final int TAGiEncodedUnderlyingIssuerLen = 362;

    public static final int TAGiEncodedUnderlyingSecurityDesc = 365;

    public static final int TAGiEncodedUnderlyingSecurityDescLen = 364;

    public static final int TAGiEncryptMethod = 98;

    public static final int TAGiEndAccruedInterestAmt = 920;

    public static final int TAGiEndCash = 922;

    public static final int TAGiEndDate = 917;

    public static final int TAGiEndSeqNo = 16;

    public static final int TAGiEventDate = 866;

    public static final int TAGiEventPx = 867;

    public static final int TAGiEventText = 868;

    public static final int TAGiEventType = 865;

    public static final int TAGiExchangeForPhysical = 411;

    public static final int TAGiExchangeRule = 825;

    public static final int TAGiExDate = 230;

    public static final int TAGiExDestination = 100;

    public static final int TAGiExecBroker = 76;

    public static final int TAGiExecID = 17;

    public static final int TAGiExecInst = 18;

    public static final int TAGiExecPriceAdjustment = 485;

    public static final int TAGiExecPriceType = 484;

    public static final int TAGiExecRefID = 19;

    public static final int TAGiExecRestatementReason = 378;

    public static final int TAGiExecTransType = 20;

    public static final int TAGiExecType = 150;

    public static final int TAGiExecValuationPoint = 515;

    public static final int TAGiExerciseMethod = 747;

    public static final int TAGiExpirationCycle = 827;

    public static final int TAGiExpireDate = 432;

    public static final int TAGiExpireTime = 126;

    public static final int TAGiFactor = 228;

    public static final int TAGiFairValue = 406;

    public static final int TAGiFinancialStatus = 291;

    public static final int TAGiForexReq = 121;

    public static final int TAGiFundRenewWaiv = 497;

    public static final int TAGiFutSettDate = 64;

    public static final int TAGiFutSettDate2 = 193;

    public static final int TAGiGapFillFlag = 123;

    public static final int TAGiGrossTradeAmt = 381;

    public static final int TAGiGTBookingInst = 427;

    public static final int TAGiHaltReason = 327;

    public static final int TAGiHandlInst = 21;

    public static final int TAGiHeadline = 148;

    public static final int TAGiHeartBtInt = 108;

    public static final int TAGiHighPx = 332;

    public static final int TAGiHopCompID = 628;

    public static final int TAGiHopRefID = 630;

    public static final int TAGiHopSendingTime = 629;

    public static final int TAGiIDSource = 22;

    public static final int TAGiIncTaxInd = 416;

    public static final int TAGiIndividualAllocID = 467;

    public static final int TAGiIndividualAllocRejCode = 776;

    public static final int TAGiInquiryResult = 946;

    public static final int TAGiInquiryStatus = 945;

    public static final int TAGiInstrAttribType = 871;

    public static final int TAGiInstrAttribValue = 872;

    public static final int TAGiInstrRegistry = 543;

    public static final int TAGiInterestAccrualDate = 874;

    public static final int TAGiInterestAtMaturity = 738;

    public static final int TAGiInvestorCountryOfResidence = 475;

    public static final int TAGiInViewOfCommon = 328;

    public static final int TAGiIOIid = 23;

    public static final int TAGiIOINaturalFlag = 130;

    public static final int TAGiIOIOthSvc = 24;

    public static final int TAGiIOIQltyInd = 25;

    public static final int TAGiIOIQty = 27;

    public static final int TAGiIOIQualifier = 104;

    public static final int TAGiIOIRefID = 26;

    public static final int TAGiIOIShares = 27;

    public static final int TAGiIOITransType = 28;

    public static final int TAGiIssueDate = 225;

    public static final int TAGiIssuer = 106;

    public static final int TAGiLastCapacity = 29;

    public static final int TAGiLastForwardPoints = 195;

    public static final int TAGiLastForwardPoints2 = 641;

    public static final int TAGiLastFragment = 893;

    public static final int TAGiLastLiquidityInd = 851;

    public static final int TAGiLastMkt = 30;

    public static final int TAGiLastMsgSeqNumProcessed = 369;

    public static final int TAGiLastNetworkReponseID = 934;

    public static final int TAGiLastParPx = 669;

    public static final int TAGiLastPx = 31;

    public static final int TAGiLastQty = 32;

    public static final int TAGiLastRptRequested = 912;

    public static final int TAGiLastShares = 32;

    public static final int TAGiLastSpotRate = 194;

    public static final int TAGiLastUpdateTime = 779;

    public static final int TAGiLeavesQty = 151;

    public static final int TAGiLegalConfirm = 650;

    public static final int TAGiLegAllocAccount = 671;

    public static final int TAGiLegAllocAcctIDSource = 674;

    public static final int TAGiLegAllocQty = 673;

    public static final int TAGiLegBenchmarkCurveCurrency = 676;

    public static final int TAGiLegBenchmarkCurveName = 677;

    public static final int TAGiLegBenchmarkCurvePoint = 678;

    public static final int TAGiLegBenchmarkPrice = 679;

    public static final int TAGiLegBenchmarkPriceType = 680;

    public static final int TAGiLegBidPx = 681;

    public static final int TAGiLegCFICode = 608;

    public static final int TAGiLegContractMultiplier = 614;

    public static final int TAGiLegCountryOfIssue = 596;

    public static final int TAGiLegCouponPaymentDate = 248;

    public static final int TAGiLegCouponRate = 615;

    public static final int TAGiLegCoveredOrUncovered = 565;

    public static final int TAGiLegCreditRating = 257;

    public static final int TAGiLegCurrency = 556;

    public static final int TAGiLegDeliveryForm = 739;

    public static final int TAGiLegFactor = 253;

    public static final int TAGiLegFutSettDate = 588;

    public static final int TAGiLegIOIQty = 682;

    public static final int TAGiLegIndividualAllocID = 672;

    public static final int TAGiLegInstrRegistry = 599;

    public static final int TAGiLegIssueDate = 249;

    public static final int TAGiLegIssuer = 617;

    public static final int TAGiLegLastPx = 637;

    public static final int TAGiLegLocaleOfIssue = 598;

    public static final int TAGiLegMaturityDate = 611;

    public static final int TAGiLegMaturityMonthYear = 610;

    public static final int TAGiLegOfferPx = 684;

    public static final int TAGiLegOptAttribute = 613;

    public static final int TAGiLegOrderQty = 685;

    public static final int TAGiLegPool = 740;

    public static final int TAGiLegPositionEffect = 564;

    public static final int TAGiLegPrice = 566;

    public static final int TAGiLegPriceType = 686;

    public static final int TAGiLegProduct = 607;

    public static final int TAGiLegQty = 687;

    public static final int TAGiLegRatioQty = 623;

    public static final int TAGiLegRedemptionDate = 254;

    public static final int TAGiLegRefID = 654;

    public static final int TAGiLegRepoCollateralSecurityType = 250;

    public static final int TAGiLegRepurchaseRate = 252;

    public static final int TAGiLegRepurchaseTerm = 251;

    public static final int TAGiLegSecurityAltID = 605;

    public static final int TAGiLegSecurityAltIDSource = 606;

    public static final int TAGiLegSecurityDesc = 620;

    public static final int TAGiLegSecurityExchange = 616;

    public static final int TAGiLegSecurityID = 602;

    public static final int TAGiLegSecurityIDSource = 603;

    public static final int TAGiLegSecuritySubType = 764;

    public static final int TAGiLegSecurityType = 609;

    public static final int TAGiLegSettlCurrency = 675;

    public static final int TAGiLegSettlDate = 588;

    public static final int TAGiLegSettlType = 587;

    public static final int TAGiLegSettlmntTyp = 587;

    public static final int TAGiLegSide = 624;

    public static final int TAGiLegStateOrProvinceOfIssue = 597;

    public static final int TAGiLegStipulationType = 688;

    public static final int TAGiLegStipulationValue = 689;

    public static final int TAGiLegStrikeCurrency = 942;

    public static final int TAGiLegStrikePrice = 612;

    public static final int TAGiLegSwapType = 690;

    public static final int TAGiLegSymbol = 600;

    public static final int TAGiLegSymbolSfx = 601;

    public static final int TAGiLinesOfText = 33;

    public static final int TAGiLiquidityIndType = 409;

    public static final int TAGiLiquidityNumSecurities = 441;

    public static final int TAGiLiquidityPctHigh = 403;

    public static final int TAGiLiquidityPctLow = 402;

    public static final int TAGiLiquidityValue = 404;

    public static final int TAGiListExecInst = 69;

    public static final int TAGiListExecInstType = 433;

    public static final int TAGiListID = 66;

    public static final int TAGiListName = 392;

    public static final int TAGiListNoOrds = 68;

    public static final int TAGiListOrderStatus = 431;

    public static final int TAGiListSeqNo = 67;

    public static final int TAGiListStatusText = 444;

    public static final int TAGiListStatusType = 429;

    public static final int TAGiLocaleOfIssue = 472;

    public static final int TAGiLocateReqd = 114;

    public static final int TAGiLocationID = 283;

    public static final int TAGiLongQty = 704;

    public static final int TAGiLowPx = 333;

    public static final int TAGiMailingDtls = 474;

    public static final int TAGiMailingInst = 482;

    public static final int TAGiMarginExcess = 899;

    public static final int TAGiMarginRatio = 898;

    public static final int TAGiMarketDepth = 264;

    public static final int TAGiMassCancelRejectReason = 532;

    public static final int TAGiMassCancelRequestType = 530;

    public static final int TAGiMassCancelResponse = 531;

    public static final int TAGiMassStatusReqID = 584;

    public static final int TAGiMassStatusReqType = 585;

    public static final int TAGiMatchStatus = 573;

    public static final int TAGiMatchType = 574;

    public static final int TAGiMaturityDate = 541;

    public static final int TAGiMaturityDay = 205;

    public static final int TAGiMaturityMonthYear = 200;

    public static final int TAGiMaturityNetMoney = 890;

    public static final int TAGiMaxFloor = 111;

    public static final int TAGiMaxMessageSize = 383;

    public static final int TAGiMaxShow = 210;

    public static final int TAGiMDEntryBuyer = 288;

    public static final int TAGiMDEntryDate = 272;

    public static final int TAGiMDEntryID = 278;

    public static final int TAGiMDEntryOriginator = 282;

    public static final int TAGiMDEntryPositionNo = 290;

    public static final int TAGiMDEntryPx = 270;

    public static final int TAGiMDEntryRefID = 280;

    public static final int TAGiMDEntrySeller = 289;

    public static final int TAGiMDEntrySize = 271;

    public static final int TAGiMDEntryTime = 273;

    public static final int TAGiMDEntryType = 269;

    public static final int TAGiMDImplicitDelete = 547;

    public static final int TAGiMDMkt = 275;

    public static final int TAGiMDReqID = 262;

    public static final int TAGiMDReqRejReason = 281;

    public static final int TAGiMDUpdateAction = 279;

    public static final int TAGiMDUpdateType = 265;

    public static final int TAGiMessageEncoding = 347;

    public static final int TAGiMidPx = 631;

    public static final int TAGiMidYield = 633;

    public static final int TAGiMinBidSize = 647;

    public static final int TAGiMinOfferSize = 648;

    public static final int TAGiMinQty = 110;

    public static final int TAGiMinTradeVol = 562;

    public static final int TAGiMiscFeeAmt = 137;

    public static final int TAGiMiscFeeBasis = 891;

    public static final int TAGiMiscFeeCurr = 138;

    public static final int TAGiMiscFeeType = 139;

    public static final int TAGiMktBidPx = 645;

    public static final int TAGiMktOfferPx = 646;

    public static final int TAGiMoneyLaunderingStatus = 481;

    public static final int TAGiMsgDirection = 385;

    public static final int TAGiMsgSeqNum = 34;

    public static final int TAGiMsgType = 35;

    public static final int TAGiMultiLegReportingType = 442;

    public static final int TAGiMultiLegRptTypeReq = 563;

    public static final int TAGiNested2PartyID = 757;

    public static final int TAGiNested2PartyIDSource = 758;

    public static final int TAGiNested2PartyRole = 759;

    public static final int TAGiNested2PartySubID = 760;

    public static final int TAGiNested2PartySubIDType = 807;

    public static final int TAGiNestedPartyID = 524;

    public static final int TAGiNestedPartyIDSource = 525;

    public static final int TAGiNestedPartyRole = 538;

    public static final int TAGiNestedPartySubID = 545;

    public static final int TAGiNestedPartySubIDType = 805;

    public static final int TAGiNetChgPrevDay = 451;

    public static final int TAGiNetGrossInd = 430;

    public static final int TAGiNetMoney = 118;

    public static final int TAGiNetworkRequestID = 933;

    public static final int TAGiNetworkRequestType = 935;

    public static final int TAGiNetworkResponseID = 932;

    public static final int TAGiNetworkStatusResponseType = 937;

    public static final int TAGiNewPassword = 925;

    public static final int TAGiNewSeqNo = 36;

    public static final int TAGiNextExpectedMsgSeqNum = 789;

    public static final int TAGiNoAffectedOrders = 534;

    public static final int TAGiNoAllocs = 78;

    public static final int TAGiNoAltMDSource = 816;

    public static final int TAGiNoBidComponents = 420;

    public static final int TAGiNoBidDescriptors = 398;

    public static final int TAGiNoCapacities = 862;

    public static final int TAGiNoClearingInstructions = 576;

    public static final int TAGiNoCollInquiryQualifier = 938;

    public static final int TAGiNoCompIDs = 936;

    public static final int TAGiNoContAmts = 518;

    public static final int TAGiNoContraBrokers = 382;

    public static final int TAGiNoDates = 580;

    public static final int TAGiNoDistribInsts = 510;

    public static final int TAGiNoDlvyInst = 85;

    public static final int TAGiNoEvents = 864;

    public static final int TAGiNoExecs = 124;

    public static final int TAGiNoHops = 627;

    public static final int TAGiNoIOIQualifiers = 199;

    public static final int TAGiNoInstrAttrib = 870;

    public static final int TAGiNoLegAllocs = 670;

    public static final int TAGiNoLegs = 555;

    public static final int TAGiNoLegSecurityAltID = 604;

    public static final int TAGiNoLegStipulations = 683;

    public static final int TAGiNoMDEntries = 268;

    public static final int TAGiNoMDEntryTypes = 267;

    public static final int TAGiNoMiscFees = 136;

    public static final int TAGiNoMsgTypes = 384;

    public static final int TAGiNoNested2PartyIDs = 756;

    public static final int TAGiNoNested2PartySubIDs = 806;

    public static final int TAGiNoNestedPartyIDs = 539;

    public static final int TAGiNoNestedPartySubIDs = 804;

    public static final int TAGiNoOrders = 73;

    public static final int TAGiNoPartyIDs = 453;

    public static final int TAGiNoPartySubIDs = 802;

    public static final int TAGiNoPosAmt = 753;

    public static final int TAGiNoPositions = 702;

    public static final int TAGiNoQuoteEntries = 295;

    public static final int TAGiNoQuoteQualifiers = 735;

    public static final int TAGiNoQuoteSets = 296;

    public static final int TAGiNoRegistDtls = 473;

    public static final int TAGiNoRelatedSym = 146;

    public static final int TAGiNoRoutingIDs = 215;

    public static final int TAGiNoRpts = 82;

    public static final int TAGiNoSecurityAltID = 454;

    public static final int TAGiNoSecurityTypes = 558;

    public static final int TAGiNoSettlInst = 778;

    public static final int TAGiNoSettlPartyIDs = 781;

    public static final int TAGiNoSettlPartySubIDs = 801;

    public static final int TAGiNoSides = 552;

    public static final int TAGiNoStipulations = 232;

    public static final int TAGiNoStrikes = 428;

    public static final int TAGiNotifyBrokerOfCredit = 208;

    public static final int TAGiNoTrades = 897;

    public static final int TAGiNoTradingSessions = 386;

    public static final int TAGiNoTrdRegTimestamps = 768;

    public static final int TAGiNoUnderlyingSecurityAltID = 457;

    public static final int TAGiNoUnderlyingStips = 887;

    public static final int TAGiNoUnderlyings = 711;

    public static final int TAGiNumberOfOrders = 346;

    public static final int TAGiNumBidders = 417;

    public static final int TAGiNumDaysInterest = 157;

    public static final int TAGiNumTickets = 395;

    public static final int TAGiOddLot = 575;

    public static final int TAGiOfferForwardPoints = 191;

    public static final int TAGiOfferForwardPoints2 = 643;

    public static final int TAGiOfferPx = 133;

    public static final int TAGiOfferSize = 135;

    public static final int TAGiOfferSpotRate = 190;

    public static final int TAGiOfferYield = 634;

    public static final int TAGiOnBehalfOfCompID = 115;

    public static final int TAGiOnBehalfOfLocationID = 144;

    public static final int TAGiOnBehalfOfSendingTime = 370;

    public static final int TAGiOnBehalfOfSubID = 116;

    public static final int TAGiOpenClose = 77;

    public static final int TAGiOpenCloseSettlFlag = 286;

    public static final int TAGiOpenCloseSettleFlag = 286;

    public static final int TAGiOpenInterest = 746;

    public static final int TAGiOptAttribute = 206;

    public static final int TAGiOrderAvgPx = 799;

    public static final int TAGiOrderBookingQty = 800;

    public static final int TAGiOrderCapacity = 528;

    public static final int TAGiOrderCapacityQty = 863;

    public static final int TAGiOrderID = 37;

    public static final int TAGiOrderInputDevice = 821;

    public static final int TAGiOrderPercent = 516;

    public static final int TAGiOrderQty = 38;

    public static final int TAGiOrderQty2 = 192;

    public static final int TAGiOrderRestrictions = 529;

    public static final int TAGiOrdRejReason = 103;

    public static final int TAGiOrdStatus = 39;

    public static final int TAGiOrdStatusReqID = 790;

    public static final int TAGiOrdType = 40;

    public static final int TAGiOrigClOrdID = 41;

    public static final int TAGiOrigCrossID = 551;

    public static final int TAGiOrigOrdModTime = 586;

    public static final int TAGiOrigPosReqRefID = 713;

    public static final int TAGiOrigSendingTime = 122;

    public static final int TAGiOrigTime = 42;

    public static final int TAGiOutMainCntryUIndex = 412;

    public static final int TAGiOutsideIndexPct = 407;

    public static final int TAGiOwnershipType = 517;

    public static final int TAGiOwnerType = 522;

    public static final int TAGiParticipationRate = 849;

    public static final int TAGiPartyID = 448;

    public static final int TAGiPartyIDSource = 447;

    public static final int TAGiPartyRole = 452;

    public static final int TAGiPartySubID = 523;

    public static final int TAGiPartySubIDType = 803;

    public static final int TAGiPassword = 554;

    public static final int TAGiPaymentDate = 504;

    public static final int TAGiPaymentMethod = 492;

    public static final int TAGiPaymentRef = 476;

    public static final int TAGiPaymentRemitterID = 505;

    public static final int TAGiPctAtRisk = 869;

    public static final int TAGiPegDifference = 211;

    public static final int TAGiPegLimitType = 837;

    public static final int TAGiPegMoveType = 835;

    public static final int TAGiPegOffsetType = 836;

    public static final int TAGiPegOffsetValue = 211;

    public static final int TAGiPegRoundDirection = 838;

    public static final int TAGiPegScope = 840;

    public static final int TAGiPeggedPrice = 839;

    public static final int TAGiPool = 691;

    public static final int TAGiPosAmt = 708;

    public static final int TAGiPosAmtType = 707;

    public static final int TAGiPosMaintAction = 712;

    public static final int TAGiPosMaintResult = 723;

    public static final int TAGiPosMaintRptID = 721;

    public static final int TAGiPosMaintRptRefID = 714;

    public static final int TAGiPosMaintStatus = 722;

    public static final int TAGiPosQtyStatus = 706;

    public static final int TAGiPosReqID = 710;

    public static final int TAGiPosReqResult = 728;

    public static final int TAGiPosReqStatus = 729;

    public static final int TAGiPosReqType = 724;

    public static final int TAGiPosTransType = 709;

    public static final int TAGiPosType = 703;

    public static final int TAGiPositionEffect = 77;

    public static final int TAGiPossDupFlag = 43;

    public static final int TAGiPossResend = 97;

    public static final int TAGiPreallocMethod = 591;

    public static final int TAGiPrevClosePx = 140;

    public static final int TAGiPreviouslyReported = 570;

    public static final int TAGiPrice = 44;

    public static final int TAGiPrice2 = 640;

    public static final int TAGiPriceDelta = 811;

    public static final int TAGiPriceImprovement = 639;

    public static final int TAGiPriceType = 423;

    public static final int TAGiPriorSettlPrice = 734;

    public static final int TAGiPriorSpreadIndicator = 720;

    public static final int TAGiPriorityIndicator = 638;

    public static final int TAGiProcessCode = 81;

    public static final int TAGiProduct = 460;

    public static final int TAGiProgPeriodInterval = 415;

    public static final int TAGiProgRptReqs = 414;

    public static final int TAGiPublishTrdIndicator = 852;

    public static final int TAGiPutOrCall = 201;

    public static final int TAGiQtyType = 854;

    public static final int TAGiQuantity = 53;

    public static final int TAGiQuantityType = 465;

    public static final int TAGiQuoteAckStatus = 297;

    public static final int TAGiQuoteCancelType = 298;

    public static final int TAGiQuoteCondition = 276;

    public static final int TAGiQuoteEntryID = 299;

    public static final int TAGiQuoteEntryRejectReason = 368;

    public static final int TAGiQuoteID = 117;

    public static final int TAGiQuotePriceType = 692;

    public static final int TAGiQuoteQualifier = 695;

    public static final int TAGiQuoteRejectReason = 300;

    public static final int TAGiQuoteReqID = 131;

    public static final int TAGiQuoteRequestRejectReason = 658;

    public static final int TAGiQuoteRequestType = 303;

    public static final int TAGiQuoteRespID = 693;

    public static final int TAGiQuoteRespType = 694;

    public static final int TAGiQuoteResponseLevel = 301;

    public static final int TAGiQuoteSetID = 302;

    public static final int TAGiQuoteSetValidUntilTime = 367;

    public static final int TAGiQuoteStatus = 297;

    public static final int TAGiQuoteStatusReqID = 649;

    public static final int TAGiQuoteType = 537;

    public static final int TAGiRatioQty = 319;

    public static final int TAGiRawData = 96;

    public static final int TAGiRawDataLength = 95;

    public static final int TAGiRedemptionDate = 240;

    public static final int TAGiRefAllocID = 72;

    public static final int TAGiRefMsgType = 372;

    public static final int TAGiRefSeqNum = 45;

    public static final int TAGiRefTagID = 371;

    public static final int TAGiRegistAcctType = 493;

    public static final int TAGiRegistDetls = 509;

    public static final int TAGiRegistEmail = 511;

    public static final int TAGiRegistID = 513;

    public static final int TAGiRegistRefID = 508;

    public static final int TAGiRegistRejReasonCode = 507;

    public static final int TAGiRegistRejReasonText = 496;

    public static final int TAGiRegistStatus = 506;

    public static final int TAGiRegistTransType = 514;

    public static final int TAGiRelatdSym = 46;

    public static final int TAGiRepoCollateralSecurityType = 239;

    public static final int TAGiReportToExch = 113;

    public static final int TAGiReportedPx = 861;

    public static final int TAGiRepurchaseRate = 227;

    public static final int TAGiRepurchaseTerm = 226;

    public static final int TAGiResetSeqNumFlag = 141;

    public static final int TAGiResponseDestination = 726;

    public static final int TAGiResponseTransportType = 725;

    public static final int TAGiReversalIndicator = 700;

    public static final int TAGiRFQReqID = 644;

    public static final int TAGiRoundingDirection = 468;

    public static final int TAGiRoundingModulus = 469;

    public static final int TAGiRoundLot = 561;

    public static final int TAGiRoutingID = 217;

    public static final int TAGiRoutingType = 216;

    public static final int TAGiRptSeq = 83;

    public static final int TAGiRule80A = 47;

    public static final int TAGiScope = 546;

    public static final int TAGiSecDefStatus = 653;

    public static final int TAGiSecondaryAllocID = 793;

    public static final int TAGiSecondaryClOrdID = 526;

    public static final int TAGiSecondaryExecID = 527;

    public static final int TAGiSecondaryOrderID = 198;

    public static final int TAGiSecondaryTradeReportID = 818;

    public static final int TAGiSecondaryTradeReportRefID = 881;

    public static final int TAGiSecondaryTrdType = 855;

    public static final int TAGiSecureData = 91;

    public static final int TAGiSecureDataLen = 90;

    public static final int TAGiSecurityAltID = 455;

    public static final int TAGiSecurityAltIDSource = 456;

    public static final int TAGiSecurityDesc = 107;

    public static final int TAGiSecurityExchange = 207;

    public static final int TAGiSecurityID = 48;

    public static final int TAGiSecurityIDSource = 22;

    public static final int TAGiSecurityListRequestType = 559;

    public static final int TAGiSecurityReqID = 320;

    public static final int TAGiSecurityRequestResult = 560;

    public static final int TAGiSecurityRequestType = 321;

    public static final int TAGiSecurityResponseID = 322;

    public static final int TAGiSecurityResponseType = 323;

    public static final int TAGiSecuritySettlAgentAcctName = 179;

    public static final int TAGiSecuritySettlAgentAcctNum = 178;

    public static final int TAGiSecuritySettlAgentCode = 177;

    public static final int TAGiSecuritySettlAgentContactName = 180;

    public static final int TAGiSecuritySettlAgentContactPhone = 181;

    public static final int TAGiSecuritySettlAgentName = 176;

    public static final int TAGiSecurityStatusReqID = 324;

    public static final int TAGiSecuritySubType = 762;

    public static final int TAGiSecurityTradingStatus = 326;

    public static final int TAGiSecurityType = 167;

    public static final int TAGiSellerDays = 287;

    public static final int TAGiSellVolume = 331;

    public static final int TAGiSenderCompID = 49;

    public static final int TAGiSenderLocationID = 142;

    public static final int TAGiSenderSubID = 50;

    public static final int TAGiSendingDate = 51;

    public static final int TAGiSendingTime = 52;

    public static final int TAGiSessionRejectReason = 373;

    public static final int TAGiSettlBrkrCode = 174;

    public static final int TAGiSettlCurrAmt = 119;

    public static final int TAGiSettlCurrBidFxRate = 656;

    public static final int TAGiSettlCurrency = 120;

    public static final int TAGiSettlCurrFxRate = 155;

    public static final int TAGiSettlCurrFxRateCalc = 156;

    public static final int TAGiSettlCurrOfferFxRate = 657;

    public static final int TAGiSettlDate = 64;

    public static final int TAGiSettlDate2 = 193;

    public static final int TAGiSettlDeliveryType = 172;

    public static final int TAGiSettlDepositoryCode = 173;

    public static final int TAGiSettlInstCode = 175;

    public static final int TAGiSettlInstID = 162;

    public static final int TAGiSettlInstMode = 160;

    public static final int TAGiSettlInstMsgID = 777;

    public static final int TAGiSettlInstRefID = 214;

    public static final int TAGiSettlInstReqID = 791;

    public static final int TAGiSettlInstReqRejCode = 792;

    public static final int TAGiSettlInstSource = 165;

    public static final int TAGiSettlInstTransType = 163;

    public static final int TAGiSettlLocation = 166;

    public static final int TAGiSettlPartyID = 782;

    public static final int TAGiSettlPartyIDSource = 783;

    public static final int TAGiSettlPartyRole = 784;

    public static final int TAGiSettlPartySubID = 785;

    public static final int TAGiSettlPartySubIDType = 786;

    public static final int TAGiSettlPrice = 730;

    public static final int TAGiSettlPriceType = 731;

    public static final int TAGiSettlSessID = 716;

    public static final int TAGiSettlSessSubID = 717;

    public static final int TAGiSettlType = 63;

    public static final int TAGiSettlmntTyp = 63;

    public static final int TAGiSharedCommission = 858;

    public static final int TAGiShares = 53;

    public static final int TAGiShortQty = 705;

    public static final int TAGiShortSaleReason = 853;

    public static final int TAGiSide = 54;

    public static final int TAGiSideComplianceID = 659;

    public static final int TAGiSideMultilegReportingType = 752;

    public static final int TAGiSideValue1 = 396;

    public static final int TAGiSideValue2 = 397;

    public static final int TAGiSideValueInd = 401;

    public static final int TAGiSignature = 89;

    public static final int TAGiSignatureLength = 93;

    public static final int TAGiSolicitedFlag = 377;

    public static final int TAGiSpread = 218;

    public static final int TAGiSpreadToBenchmark = 218;

    public static final int TAGiStandInstDbID = 171;

    public static final int TAGiStandInstDbName = 170;

    public static final int TAGiStandInstDbType = 169;

    public static final int TAGiStartCash = 921;

    public static final int TAGiStartDate = 916;

    public static final int TAGiStateOrProvinceOfIssue = 471;

    public static final int TAGiStatusText = 929;

    public static final int TAGiStatusValue = 928;

    public static final int TAGiStipulationType = 233;

    public static final int TAGiStipulationValue = 234;

    public static final int TAGiStopPx = 99;

    public static final int TAGiStrikeCurrency = 919;

    public static final int TAGiStrikePrice = 202;

    public static final int TAGiStrikeTime = 443;

    public static final int TAGiSubID = 931;

    public static final int TAGiSubject = 147;

    public static final int TAGiSubscriptionRequestType = 263;

    public static final int TAGiSymbol = 55;

    public static final int TAGiSymbolSfx = 65;

    public static final int TAGiTargetCompID = 56;

    public static final int TAGiTargetLocationID = 143;

    public static final int TAGiTargetStrategy = 847;

    public static final int TAGiTargetStrategyParameters = 848;

    public static final int TAGiTargetStrategyPerformance = 850;

    public static final int TAGiTargetSubID = 57;

    public static final int TAGiTaxAdvantageType = 495;

    public static final int TAGiTerminationType = 788;

    public static final int TAGiTestMessageIndicator = 464;

    public static final int TAGiTestReqID = 112;

    public static final int TAGiText = 58;

    public static final int TAGiThresholdAmount = 834;

    public static final int TAGiTickDirection = 274;

    public static final int TAGiTimeBracket = 943;

    public static final int TAGiTimeInForce = 59;

    public static final int TAGiTotalAccruedInterestAmt = 540;

    public static final int TAGiTotalAffectedOrders = 533;

    public static final int TAGiTotalNetValue = 900;

    public static final int TAGiTotalNumPosReports = 727;

    public static final int TAGiTotalNumSecurities = 393;

    public static final int TAGiTotalNumSecurityTypes = 557;

    public static final int TAGiTotalTakedown = 237;

    public static final int TAGiTotalVolumeTraded = 387;

    public static final int TAGiTotalVolumeTradedDate = 449;

    public static final int TAGiTotalVolumeTradedTime = 450;

    public static final int TAGiTotNoAllocs = 892;

    public static final int TAGiTotNoOrders = 68;

    public static final int TAGiTotNoQuoteEntries = 304;

    public static final int TAGiTotNoRelatedSym = 393;

    public static final int TAGiTotNoStrikes = 422;

    public static final int TAGiTotNumAssignmentReports = 832;

    public static final int TAGiTotNumReports = 911;

    public static final int TAGiTotNumSecurityTypes = 557;

    public static final int TAGiTotNumTradeReports = 748;

    public static final int TAGiTotQuoteEntries = 304;

    public static final int TAGiTradeAllocIndicator = 826;

    public static final int TAGiTradeCondition = 277;

    public static final int TAGiTradeDate = 75;

    public static final int TAGiTradedFlatSwitch = 258;

    public static final int TAGiTradeInputDevice = 579;

    public static final int TAGiTradeInputSource = 578;

    public static final int TAGiTradeLegRefID = 824;

    public static final int TAGiTradeLinkID = 820;

    public static final int TAGiTradeOriginationDate = 229;

    public static final int TAGiTradeReportID = 571;

    public static final int TAGiTradeReportRefID = 572;

    public static final int TAGiTradeReportRejectReason = 751;

    public static final int TAGiTradeReportTransType = 487;

    public static final int TAGiTradeReportType = 856;

    public static final int TAGiTradeRequestID = 568;

    public static final int TAGiTradeRequestResult = 749;

    public static final int TAGiTradeRequestStatus = 750;

    public static final int TAGiTradeRequestType = 569;

    public static final int TAGiTradeType = 418;

    public static final int TAGiTradingSessionID = 336;

    public static final int TAGiTradingSessionSubID = 625;

    public static final int TAGiTradSesCloseTime = 344;

    public static final int TAGiTradSesEndTime = 345;

    public static final int TAGiTradSesMethod = 338;

    public static final int TAGiTradSesMode = 339;

    public static final int TAGiTradSesOpenTime = 342;

    public static final int TAGiTradSesPreCloseTime = 343;

    public static final int TAGiTradSesReqID = 335;

    public static final int TAGiTradSesStartTime = 341;

    public static final int TAGiTradSesStatus = 340;

    public static final int TAGiTradSesStatusRejReason = 567;

    public static final int TAGiTransactTime = 60;

    public static final int TAGiTransBkdTime = 483;

    public static final int TAGiTransferReason = 830;

    public static final int TAGiTrdMatchID = 880;

    public static final int TAGiTrdRegTimestamp = 769;

    public static final int TAGiTrdRegTimestampOrigin = 771;

    public static final int TAGiTrdRegTimestampType = 770;

    public static final int TAGiTrdRptStatus = 939;

    public static final int TAGiTrdSubType = 829;

    public static final int TAGiTrdType = 828;

    public static final int TAGiUnderlyingCFICode = 463;

    public static final int TAGiUnderlyingCPProgram = 877;

    public static final int TAGiUnderlyingCPRegType = 878;

    public static final int TAGiUnderlyingContractMultiplier = 436;

    public static final int TAGiUnderlyingCountryOfIssue = 592;

    public static final int TAGiUnderlyingCouponPaymentDate = 241;

    public static final int TAGiUnderlyingCouponRate = 435;

    public static final int TAGiUnderlyingCreditRating = 256;

    public static final int TAGiUnderlyingCurrency = 318;

    public static final int TAGiUnderlyingCurrentValue = 885;

    public static final int TAGiUnderlyingDirtyPrice = 882;

    public static final int TAGiUnderlyingEndPrice = 883;

    public static final int TAGiUnderlyingEndValue = 886;

    public static final int TAGiUnderlyingFactor = 246;

    public static final int TAGiUnderlyingIDSource = 305;

    public static final int TAGiUnderlyingInstrRegistry = 595;

    public static final int TAGiUnderlyingIssueDate = 242;

    public static final int TAGiUnderlyingIssuer = 306;

    public static final int TAGiUnderlyingLastPx = 651;

    public static final int TAGiUnderlyingLastQty = 652;

    public static final int TAGiUnderlyingLocaleOfIssue = 594;

    public static final int TAGiUnderlyingMaturityDate = 542;

    public static final int TAGiUnderlyingMaturityDay = 314;

    public static final int TAGiUnderlyingMaturityMonthYear = 313;

    public static final int TAGiUnderlyingOptAttribute = 317;

    public static final int TAGiUnderlyingProduct = 462;

    public static final int TAGiUnderlyingPutOrCall = 315;

    public static final int TAGiUnderlyingPx = 810;

    public static final int TAGiUnderlyingQty = 879;

    public static final int TAGiUnderlyingRedemptionDate = 247;

    public static final int TAGiUnderlyingRepoCollateralSecurityType = 243;

    public static final int TAGiUnderlyingRepurchaseRate = 245;

    public static final int TAGiUnderlyingRepurchaseTerm = 244;

    public static final int TAGiUnderlyingSecurityAltID = 458;

    public static final int TAGiUnderlyingSecurityAltIDSource = 459;

    public static final int TAGiUnderlyingSecurityDesc = 307;

    public static final int TAGiUnderlyingSecurityExchange = 308;

    public static final int TAGiUnderlyingSecurityID = 309;

    public static final int TAGiUnderlyingSecurityIDSource = 305;

    public static final int TAGiUnderlyingSecuritySubType = 763;

    public static final int TAGiUnderlyingSecurityType = 310;

    public static final int TAGiUnderlyingSettlPrice = 732;

    public static final int TAGiUnderlyingSettlPriceType = 733;

    public static final int TAGiUnderlyingStartValue = 884;

    public static final int TAGiUnderlyingStateOrProvinceOfIssue = 593;

    public static final int TAGiUnderlyingStipType = 888;

    public static final int TAGiUnderlyingStipValue = 889;

    public static final int TAGiUnderlyingStrikeCurrency = 941;

    public static final int TAGiUnderlyingStrikePrice = 316;

    public static final int TAGiUnderlyingSymbol = 311;

    public static final int TAGiUnderlyingSymbolSfx = 312;

    public static final int TAGiUnderlyingTradingSessionID = 822;

    public static final int TAGiUnderlyingTradingSessionSubID = 823;

    public static final int TAGiUnsolicitedIndicator = 325;

    public static final int TAGiUrgency = 61;

    public static final int TAGiURLLink = 149;

    public static final int TAGiUserRequestID = 923;

    public static final int TAGiUserRequestType = 924;

    public static final int TAGiUserStatus = 926;

    public static final int TAGiUserStatusText = 927;

    public static final int TAGiUsername = 553;

    public static final int TAGiValidUntilTime = 62;

    public static final int TAGiValueOfFutures = 408;

    public static final int TAGiWaveNo = 105;

    public static final int TAGiWorkingIndicator = 636;

    public static final int TAGiWtAverageLiquidity = 410;

    public static final int TAGiXmlData = 213;

    public static final int TAGiXmlDataLen = 212;

    public static final int TAGiYield = 236;

    public static final int TAGiYieldCalcDate = 701;

    public static final int TAGiYieldRedemptionDate = 696;

    public static final int TAGiYieldRedemptionPrice = 697;

    public static final int TAGiYieldRedemptionPriceType = 698;

    public static final int TAGiYieldType = 235;

    public static final int TYPEChar = 1;

    public static final int TYPEData = 2;

    public static final int TYPEDate = 3;

    public static final int TYPEFloat = 4;

    public static final int TYPEInt = 5;

    public static final int TYPETime = 6;

    public static final int TYPEAmt = 401;

    public static final int TYPEBoolean = 201;

    public static final int TYPECountry = 105;

    public static final int TYPECurrency = 101;

    public static final int TYPEDayOfMonth = 501;

    public static final int TYPEExchange = 102;

    public static final int TYPELength = 502;

    public static final int TYPELocalMktDate = 301;

    public static final int TYPEMonthYear = 302;

    public static final int TYPEMultipleValueString = 103;

    public static final int TYPENumInGroup = 503;

    public static final int TYPEPercentage = 405;

    public static final int TYPEPrice = 402;

    public static final int TYPEPriceOffset = 403;

    public static final int TYPEQty = 404;

    public static final int TYPESeqNum = 504;

    public static final int TYPEString = 104;

    public static final int TYPEUTCDate = 303;

    public static final int TYPEUTCDateOnly = 303;

    public static final int TYPEUTCTimeOnly = 304;

    public static final int TYPEUTCTimestamp = 305;

    public static final String ACCTIDSOURCE_BIC = "1";

    public static final String ACCTIDSOURCE_SIDCode = "2";

    public static final String ACCTIDSOURCE_TFM = "3";

    public static final String ACCTIDSOURCE_OMGEO = "4";

    public static final String ACCTIDSOURCE_DTCC = "5";

    public static final String ACCTIDSOURCE_OTHER = "99";

    public static final String ALLOCACCTIDSOURCE_BIC = "1";

    public static final String ALLOCACCTIDSOURCE_SIDCode = "2";

    public static final String ALLOCACCTIDSOURCE_TFM = "3";

    public static final String ALLOCACCTIDSOURCE_OMGEO = "4";

    public static final String ALLOCACCTIDSOURCE_DTCC = "5";

    public static final String ALLOCACCTIDSOURCE_OTHER = "99";

    public static final String ALLOCHANDLINST_Match = "1";

    public static final String ALLOCHANDLINST_Forward = "2";

    public static final String ALLOCHANDLINST_ForwardAndMatch = "3";

    public static final String ALLOCLINKTYPE_FXNetting = "0";

    public static final String ALLOCLINKTYPE_FXSwap = "1";

    public static final String ALLOCTRANSTYPE_New = "0";

    public static final String ALLOCTRANSTYPE_Replace = "1";

    public static final String ALLOCTRANSTYPE_Cancel = "2";

    public static final String ALLOCTRANSTYPE_Preliminary = "3";

    public static final String ALLOCTRANSTYPE_Calculated = "4";

    public static final String ALLOCTRANSTYPE_CalculatedWithoutPreliminary = "5";

    public static final String ALLOCSTATUS_Accepted = "0";

    public static final String ALLOCSTATUS_BlockLevelReject = "1";

    public static final String ALLOCSTATUS_AccountLevelReject = "2";

    public static final String ALLOCSTATUS_Received = "3";

    public static final String ALLOCSTATUS_Incomplete = "4";

    public static final String ALLOCSTATUS_RejectedByIntermediary = "5";

    public static final String ALLOCREJCODE_UnknownAccount = "0";

    public static final String ALLOCREJCODE_IncorrectQuantity = "1";

    public static final String ALLOCREJCODE_IncorrectAveragePrice = "2";

    public static final String ALLOCREJCODE_UnknownExecutingBrokerMnemonic = "3";

    public static final String ALLOCREJCODE_CommissionDifference = "4";

    public static final String ALLOCREJCODE_UnknownOrderID = "5";

    public static final String ALLOCREJCODE_UnknownListID = "6";

    public static final String ALLOCREJCODE_Other = "7";

    public static final String ALLOCREJCODE_IncorrectAllocatedQuantity = "8";

    public static final String ALLOCREJCODE_CalculationDifference = "9";

    public static final String ALLOCREJCODE_UnknownOrStaleExecID = "10";

    public static final String ALLOCREJCODE_MismatchedDataValue = "11";

    public static final String ALLOCREJCODE_UnknownClOrdID = "12";

    public static final String ALLOCREJCODE_WarehouseRequestRejected = "13";

    public static final String ALLOCNOORDERSTYPE_NotSpecified = "0";

    public static final String ALLOCNOORDERSTYPE_ExplicitListProvided = "1";

    public static final String ALLOCINTERMEDREQTYPE_PendingAccept = "1";

    public static final String ALLOCINTERMEDREQTYPE_PendingRelease = "2";

    public static final String ALLOCINTERMEDREQTYPE_PendingReversal = "3";

    public static final String ALLOCINTERMEDREQTYPE_Accept = "4";

    public static final String ALLOCINTERMEDREQTYPE_BlockLevelReject = "5";

    public static final String ALLOCINTERMEDREQTYPE_AccountLevelReject = "6";

    public static final String ALLOCACCOUNTTYPE_CustomerSideOfBooks = "1";

    public static final String ALLOCACCOUNTTYPE_NonCustomerSideOfBooks = "2";

    public static final String ALLOCACCOUNTTYPE_HouseTrader = "3";

    public static final String ALLOCACCOUNTTYPE_FloorTrader = "4";

    public static final String ALLOCACCOUNTTYPE_CrossMargined = "6";

    public static final String ALLOCACCOUNTTYPE_HouseTraderAndCrossMarginated = "7";

    public static final String ALLOCACCOUNTTYPE_JBO = "8";

    public static final String ALLOCCANCREPLACEREASON_OriginalDetailsIncompleteIncorrect = "1";

    public static final String ALLOCCANCREPLACEREASON_ChangeInUnderlyingOrderDetails = "2";

    public static final String ALLOCCANCREPLACEREASON_Other = "99";

    public static final String ALLOCREPORTTYPE_SellsideCalculatedUsingPreliminary = "3";

    public static final String ALLOCREPORTTYPE_SellsideCalculatedWithoutPreliminary = "4";

    public static final String ALLOCREPORTTYPE_WarehouseRecap = "5";

    public static final String ALLOCREPORTTYPE_RequestToIntermediary = "8";

    public static final String ALLOCSETTLINSTTYPE_UseDefaultInstructions = "0";

    public static final String ALLOCSETTLINSTTYPE_DeriveFromParametersProvided = "1";

    public static final String ALLOCSETTLINSTTYPE_FullDetailsProvided = "2";

    public static final String ALLOCSETTLINSTTYPE_SSIdbIDsProvided = "3";

    public static final String ALLOCSETTLINSTTYPE_PhoneForInstructions = "4";

    public static final String ALLOCTYPE_Calculated = "1";

    public static final String ALLOCTYPE_Preliminary = "2";

    public static final String ALLOCTYPE_SellsideCalculatedUsingPreliminary = "3";

    public static final String ALLOCTYPE_SellsideCalculatedWithoutPreliminary = "4";

    public static final String ALLOCTYPE_ReadyToBook = "5";

    public static final String ALLOCTYPE_BuysideReadyToBook = "6";

    public static final String ALLOCTYPE_WarehouseInstruction = "7";

    public static final String ALLOCTYPE_RequestToIntermediary = "8";

    public static final String ADVSIDE_Buy = "B";

    public static final String ADVSIDE_Sell = "S";

    public static final String ADVSIDE_Cross = "X";

    public static final String ADVSIDE_Trade = "T";

    public static final String ADVTRANSTYPE_New = "N";

    public static final String ADVTRANSTYPE_Cancel = "C";

    public static final String ADVTRANSTYPE_Replace = "R";

    public static final String BUSINESSREJECTREASON_Other = "0";

    public static final String BUSINESSREJECTREASON_UnknownID = "1";

    public static final String BUSINESSREJECTREASON_UnknownSecurity = "2";

    public static final String BUSINESSREJECTREASON_UnsupportedMessageType = "3";

    public static final String BUSINESSREJECTREASON_ApplicationUnavailable = "4";

    public static final String BUSINESSREJECTREASON_MissingConditionalField = "5";

    public static final String BUSINESSREJECTREASON_NotAuthorized = "6";

    public static final String BUSINESSREJECTREASON_DeliverToUnavailable = "7";

    public static final String CXLREJREASON_TooLateToCancel = "0";

    public static final String CXLREJREASON_UnknownOrder = "1";

    public static final String CXLREJREASON_BrokerOption = "2";

    public static final String CXLREJREASON_PendingStatus = "3";

    public static final String CXLREJREASON_UnableToProcess = "4";

    public static final String CXLREJREASON_TimeMismatch = "5";

    public static final String CXLREJREASON_DuplicateClOrdID = "6";

    public static final String CXLREJRESPONSETO_OrderCancelRequest = "1";

    public static final String CXLREJRESPONSETO_OrderCancelReplaceRequest = "2";

    public static final String DKREASON_UnknownSymbol = "A";

    public static final String DKREASON_WrongSide = "B";

    public static final String DKREASON_QuantityExceedsOrder = "C";

    public static final String DKREASON_NoMatchingOrder = "D";

    public static final String DKREASON_PriceExceedsLimit = "E";

    public static final String DKREASON_Other = "Z";

    public static final String EXECTRANSTYPE_New = "0";

    public static final String EXECTRANSTYPE_Cancel = "1";

    public static final String EXECTRANSTYPE_Correct = "2";

    public static final String EXECTRANSTYPE_Status = "3";

    public static final String EXECTYPE_New = "0";

    public static final String EXECTYPE_PartiallyFilled = "1";

    public static final String EXECTYPE_Filled = "2";

    public static final String EXECTYPE_DoneForDay = "3";

    public static final String EXECTYPE_Cancelled = "4";

    public static final String EXECTYPE_Replaced = "5";

    public static final String EXECTYPE_PendingCancel = "6";

    public static final String EXECTYPE_Stopped = "7";

    public static final String EXECTYPE_Rejected = "8";

    public static final String EXECTYPE_Suspended = "9";

    public static final String EXECTYPE_PendingNew = "A";

    public static final String EXECTYPE_Calculated = "B";

    public static final String EXECTYPE_Expired = "C";

    public static final String EXECTYPE_Restated = "D";

    public static final String EXECTYPE_PendingReplace = "E";

    public static final String EXECTYPE_Trade = "F";

    public static final String EXECTYPE_TradeCorrect = "G";

    public static final String EXECTYPE_TradeCancel = "H";

    public static final String EXECTYPE_OrderStatus = "I";

    public static final String HANDLINST_AutoPrivateNoBroker = "1";

    public static final String HANDLINST_AutoPublicBrokerOK = "2";

    public static final String HANDLINST_Manual = "3";

    public static final String IDSOURCE_Cusip = "1";

    public static final String IDSOURCE_Sedol = "2";

    public static final String IDSOURCE_Quik = "3";

    public static final String IDSOURCE_Isin = "4";

    public static final String IDSOURCE_Ric = "5";

    public static final String IDSOURCE_ISOCurrency = "6";

    public static final String IDSOURCE_ISOCountry = "7";

    public static final String IDSOURCE_ExchangeSymbol = "8";

    public static final String IDSOURCE_CTASymbol = "9";

    public static final String IDSOURCE_Bloomberg = "A";

    public static final String IDSOURCE_Wertpapier = "B";

    public static final String IDSOURCE_Dutch = "C";

    public static final String IDSOURCE_Valoren = "D";

    public static final String IDSOURCE_Sicovam = "E";

    public static final String IDSOURCE_Belgian = "F";

    public static final String IDSOURCE_Common = "G";

    public static final String SECURITYIDSOURCE_Cusip = "1";

    public static final String SECURITYIDSOURCE_Sedol = "2";

    public static final String SECURITYIDSOURCE_Quik = "3";

    public static final String SECURITYIDSOURCE_Isin = "4";

    public static final String SECURITYIDSOURCE_Ric = "5";

    public static final String SECURITYIDSOURCE_ISOCurrency = "6";

    public static final String SECURITYIDSOURCE_ISOCountry = "7";

    public static final String SECURITYIDSOURCE_ExchangeSymbol = "8";

    public static final String SECURITYIDSOURCE_CTASymbol = "9";

    public static final String SECURITYIDSOURCE_Bloomberg = "A";

    public static final String SECURITYIDSOURCE_Wertpapier = "B";

    public static final String SECURITYIDSOURCE_Dutch = "C";

    public static final String SECURITYIDSOURCE_Valoren = "D";

    public static final String SECURITYIDSOURCE_Sicovam = "E";

    public static final String SECURITYIDSOURCE_Belgian = "F";

    public static final String SECURITYIDSOURCE_Common = "G";

    public static final String INDIVIDUALALLOCREJCODE_UnknownAccount = "0";

    public static final String INDIVIDUALALLOCREJCODE_IncorrectQuantity = "1";

    public static final String INDIVIDUALALLOCREJCODE_IncorrectAveragePrice = "2";

    public static final String INDIVIDUALALLOCREJCODE_UnknownExecutingBrokerMnemonic = "3";

    public static final String INDIVIDUALALLOCREJCODE_CommissionDifference = "4";

    public static final String INDIVIDUALALLOCREJCODE_UnknownOrderID = "5";

    public static final String INDIVIDUALALLOCREJCODE_UnknownListID = "6";

    public static final String INDIVIDUALALLOCREJCODE_Other = "7";

    public static final String INDIVIDUALALLOCREJCODE_IncorrectAllocatedQuantity = "8";

    public static final String INDIVIDUALALLOCREJCODE_CalculationDifference = "9";

    public static final String INDIVIDUALALLOCREJCODE_UnknownOrStaleExecID = "10";

    public static final String INDIVIDUALALLOCREJCODE_MismatchedDataValue = "11";

    public static final String INDIVIDUALALLOCREJCODE_UnknownClOrdID = "12";

    public static final String INDIVIDUALALLOCREJCODE_WarehouseRequestRejected = "13";

    public static final String IOINATURALFLAG_Natural = "Y";

    public static final String IOINATURALFLAG_NotNatural = "N";

    public static final String IOIOTHSVC_Autex = "A";

    public static final String IOIOTHSVC_Bridge = "B";

    public static final String IOIQUALIFIER_AllOrNone = "A";

    public static final String IOIQUALIFIER_MarketOnClose = "B";

    public static final String IOIQUALIFIER_AtTheClose = "C";

    public static final String IOIQUALIFIER_VWAP = "D";

    public static final String IOIQUALIFIER_InTouchWith = "I";

    public static final String IOIQUALIFIER_Limit = "L";

    public static final String IOIQUALIFIER_MoreBehind = "M";

    public static final String IOIQUALIFIER_AtTheOpen = "O";

    public static final String IOIQUALIFIER_TakingPosition = "P";

    public static final String IOIQUALIFIER_AtTheMarket = "Q";

    public static final String IOIQUALIFIER_CurrentQuote = "Q";

    public static final String IOIQUALIFIER_ReadyToTrade = "R";

    public static final String IOIQUALIFIER_PortfolioShown = "S";

    public static final String IOIQUALIFIER_ThroughTheDay = "T";

    public static final String IOIQUALIFIER_Versus = "V";

    public static final String IOIQUALIFIER_IndicationWorkingAway = "W";

    public static final String IOIQUALIFIER_CrossingOpportunity = "X";

    public static final String IOIQUALIFIER_AtTheMidpoint = "Y";

    public static final String IOIQUALIFIER_Preopen = "Z";

    public static final String IOIQLTYIND_Low = "L";

    public static final String IOIQLTYIND_Medium = "M";

    public static final String IOIQLTYIND_High = "H";

    public static final String IOIQTY_Small = "S";

    public static final String IOIQTY_Medium = "M";

    public static final String IOIQTY_Large = "L";

    public static final String IOISHARES_Small = "S";

    public static final String IOISHARES_Medium = "M";

    public static final String IOISHARES_Large = "L";

    public static final String IOITRANSTYPE_New = "N";

    public static final String IOITRANSTYPE_Cancel = "C";

    public static final String IOITRANSTYPE_Replace = "R";

    public static final String LEGALLOCACCTIDSOURCE_BIC = "1";

    public static final String LEGALLOCACCTIDSOURCE_SIDCode = "2";

    public static final String LEGALLOCACCTIDSOURCE_TFM = "3";

    public static final String LEGALLOCACCTIDSOURCE_OMGEO = "4";

    public static final String LEGALLOCACCTIDSOURCE_DTCC = "5";

    public static final String LEGALLOCACCTIDSOURCE_OTHER = "99";

    public static final String MARKETDEPTH_FullBook = "0";

    public static final String MARKETDEPTH_TopOfBook = "1";

    public static final char MDENTRYTYPEc_Bid = 48;

    public static final char MDENTRYTYPEc_Offer = 49;

    public static final char MDENTRYTYPEc_Trade = 50;

    public static final char MDENTRYTYPEc_IndexValue = 51;

    public static final char MDENTRYTYPEc_OpeningPrice = 52;

    public static final char MDENTRYTYPEc_ClosingPrice = 53;

    public static final char MDENTRYTYPEc_SettlementPrice = 54;

    public static final char MDENTRYTYPEc_TradingSessionHighPrice = 55;

    public static final char MDENTRYTYPEc_TradingSessionLowPrice = 56;

    public static final char MDENTRYTYPEc_TradingSessionVWAPPrice = 57;

    public static final char MDENTRYTYPEc_Imbalance = 65;

    public static final char MDENTRYTYPEc_TradeVolume = 66;

    public static final char MDENTRYTYPEc_OpenInterest = 67;

    public static final String MDENTRYTYPE_Bid = String.valueOf('0');

    public static final String MDENTRYTYPE_Offer = String.valueOf('1');

    public static final String MDENTRYTYPE_Trade = String.valueOf('2');

    public static final String MDENTRYTYPE_IndexValue = String.valueOf('3');

    public static final String MDENTRYTYPE_OpeningPrice = String.valueOf('4');

    public static final String MDENTRYTYPE_ClosingPrice = String.valueOf('5');

    public static final String MDENTRYTYPE_SettlementPrice = String.valueOf('6');

    public static final String MDENTRYTYPE_TradingSessionHighPrice = String.valueOf('7');

    public static final String MDENTRYTYPE_TradingSessionLowPrice = String.valueOf('8');

    public static final String MDENTRYTYPE_TradingSessionVWAPPrice = String.valueOf('9');

    public static final String MDENTRYTYPE_Imbalance = String.valueOf('A');

    public static final String MDENTRYTYPE_TradeVolume = String.valueOf('B');

    public static final String MDENTRYTYPE_OpenInterest = String.valueOf('C');

    public static final String MDREQREJREASON_UnknownSymbol = "0";

    public static final String MDREQREJREASON_DuplicateMDReqID = "1";

    public static final String MDREQREJREASON_InsufficientBandwidth = "2";

    public static final String MDREQREJREASON_InsufficientPermissions = "3";

    public static final String MDREQREJREASON_UnsupportedSubscriptionRequestType = "4";

    public static final String MDREQREJREASON_UnsupportedMarketDepth = "5";

    public static final String MDREQREJREASON_UnsupportedMDUpdateType = "6";

    public static final String MDREQREJREASON_UnsupportedAggregatedBook = "7";

    public static final String MDREQREJREASON_UnsupportedMDEntryType = "8";

    public static final String MDREQREJREASON_UnsupportedTradingSessionID = "9";

    public static final String MDREQREJREASON_UnsupportedScope = "A";

    public static final String MDREQREJREASON_UnsupportedOpenCloseSettleFlag = "B";

    public static final String MDREQREJREASON_UnsupportedMDImplicitDelete = "C";

    public static final String MDUPDATEACTION_New = "0";

    public static final String MDUPDATEACTION_Change = "1";

    public static final String MDUPDATEACTION_Delete = "2";

    public static final int MDUPDATEACTIONi_New = 0;

    public static final int MDUPDATEACTIONi_Change = 1;

    public static final int MDUPDATEACTIONi_Delete = 2;

    public static final String MDUPDATETYPE_FullRefresh = "0";

    public static final String MDUPDATETYPE_IncrementalRefresh = "1";

    public static final String ORDREJREASON_BrokerOption = "0";

    public static final String ORDREJREASON_UnknownSymbol = "1";

    public static final String ORDREJREASON_ExchangeClosed = "2";

    public static final String ORDREJREASON_OrderExceedsLimit = "3";

    public static final String ORDREJREASON_TooLateToEnter = "4";

    public static final String ORDREJREASON_UnknownOrder = "5";

    public static final String ORDREJREASON_DuplicateOrder = "6";

    public static final String ORDREJREASON_DuplicateVerbalOrder = "7";

    public static final String ORDREJREASON_StaleOrder = "8";

    public static final String ORDREJREASON_TradeAlong = "9";

    public static final String ORDREJREASON_InvalidInvestor = "10";

    public static final String ORDREJREASON_Unsupported = "11";

    public static final String ORDREJREASON_Surveillence = "12";

    public static final String ORDSTATUS_New = "0";

    public static final String ORDSTATUS_PartiallyFilled = "1";

    public static final String ORDSTATUS_Filled = "2";

    public static final String ORDSTATUS_DoneForDay = "3";

    public static final String ORDSTATUS_Cancelled = "4";

    public static final String ORDSTATUS_Replaced = "5";

    public static final String ORDSTATUS_PendingCancel = "6";

    public static final String ORDSTATUS_Stopped = "7";

    public static final String ORDSTATUS_Rejected = "8";

    public static final String ORDSTATUS_Suspended = "9";

    public static final String ORDSTATUS_PendingNew = "A";

    public static final String ORDSTATUS_Calculated = "B";

    public static final String ORDSTATUS_Expired = "C";

    public static final String ORDSTATUS_AcceptedForBidding = "D";

    public static final String ORDSTATUS_PendingReplace = "E";

    public static final String ORDTYPE_Market = "1";

    public static final String ORDTYPE_Limit = "2";

    public static final String ORDTYPE_Stop = "3";

    public static final String ORDTYPE_Stoplimit = "4";

    public static final String ORDTYPE_MarketOnClose = "5";

    public static final String ORDTYPE_WithOrWithout = "6";

    public static final String ORDTYPE_LimitOrBetter = "7";

    public static final String ORDTYPE_LimitWithOrWithout = "8";

    public static final String ORDTYPE_OnBasis = "9";

    public static final String ORDTYPE_OnClose = "A";

    public static final String ORDTYPE_LimitOnClose = "B";

    public static final String ORDTYPE_ForexMarket = "C";

    public static final String ORDTYPE_PreviouslyQuoted = "D";

    public static final String ORDTYPE_PreviouslyIndicated = "E";

    public static final String ORDTYPE_ForexLimit = "F";

    public static final String ORDTYPE_ForexSwap = "G";

    public static final String ORDTYPE_ForexPreviouslyQuoted = "H";

    public static final String ORDTYPE_Funari = "I";

    public static final String ORDTYPE_MarketIfTouched = "J";

    public static final String ORDTYPE_MarketWithLeftoverLimit = "K";

    public static final String ORDTYPE_PreviousFundValuationPoint = "L";

    public static final String ORDTYPE_NextFundValuationPoint = "M";

    public static final String ORDTYPE_Pegged = "P";

    public static final String PREALLOCMETHOD_Prorata = "0";

    public static final String PREALLOCMETHOD_DoNotProrata = "1";

    public static final String PROCESSCODE_Regular = "0";

    public static final String PROCESSCODE_SoftDollar = "1";

    public static final String PROCESSCODE_StepIn = "2";

    public static final String PROCESSCODE_StepOut = "3";

    public static final String PROCESSCODE_SoftDollarStepIn = "4";

    public static final String PROCESSCODE_SoftDollarStepOut = "5";

    public static final String PROCESSCODE_PlanSponsor = "6";

    public static final String QUOTEACKSTATUS_Accepted = "0";

    public static final String QUOTEACKSTATUS_CanceledForSymbol = "1";

    public static final String QUOTEACKSTATUS_CanceledForSecurityType = "2";

    public static final String QUOTEACKSTATUS_CanceledForUnderlying = "3";

    public static final String QUOTEACKSTATUS_CanceledAll = "4";

    public static final String QUOTEACKSTATUS_Rejected = "5";

    public static final String QUOTEACKSTATUS_Removed = "6";

    public static final String QUOTEACKSTATUS_Expired = "7";

    public static final String QUOTEACKSTATUS_Query = "8";

    public static final String QUOTEACKSTATUS_QuoteNotFound = "9";

    public static final String QUOTEACKSTATUS_Pending = "10";

    public static final String QUOTESTATUS_Accepted = "0";

    public static final String QUOTESTATUS_CanceledForSymbol = "1";

    public static final String QUOTESTATUS_CanceledForSecurityType = "2";

    public static final String QUOTESTATUS_CanceledForUnderlying = "3";

    public static final String QUOTESTATUS_CanceledAll = "4";

    public static final String QUOTESTATUS_Rejected = "5";

    public static final String QUOTESTATUS_Removed = "6";

    public static final String QUOTESTATUS_Expired = "7";

    public static final String QUOTESTATUS_Query = "8";

    public static final String QUOTESTATUS_QuoteNotFound = "9";

    public static final String QUOTESTATUS_Pending = "10";

    public static final String QUOTEREJECTREASON_UnknownSymbol = "1";

    public static final String QUOTEREJECTREASON_ExchangeClosed = "2";

    public static final String QUOTEREJECTREASON_ExceedsLimit = "3";

    public static final String QUOTEREJECTREASON_TooLateToEnter = "4";

    public static final String QUOTEREJECTREASON_UnknownQuote = "5";

    public static final String QUOTEREJECTREASON_DuplicateQuote = "6";

    public static final String QUOTEREJECTREASON_InvalidSpread = "7";

    public static final String QUOTEREJECTREASON_InvalidPrice = "8";

    public static final String QUOTEREJECTREASON_NotAuthorized = "9";

    public static final String QUOTECANCELTYPE_CancelForSymbol = "1";

    public static final String QUOTECANCELTYPE_CancelForSecurityType = "2";

    public static final String QUOTECANCELTYPE_CancelForUnderlyingSymbol = "3";

    public static final String QUOTECANCELTYPE_CancelForAll = "4";

    public static final String SESSIONREJECTREASON_InvalidTagNumber = "0";

    public static final String SESSIONREJECTREASON_RequiredTagMissing = "1";

    public static final String SESSIONREJECTREASON_UndefinedTagForMessage = "2";

    public static final String SESSIONREJECTREASON_UndefinedTag = "3";

    public static final String SESSIONREJECTREASON_NoTagValue = "4";

    public static final String SESSIONREJECTREASON_BadTagValue = "5";

    public static final String SESSIONREJECTREASON_BadValueFormat = "6";

    public static final String SESSIONREJECTREASON_DecryptionProblem = "7";

    public static final String SESSIONREJECTREASON_SignatureProblem = "8";

    public static final String SESSIONREJECTREASON_CompIDProblem = "9";

    public static final String SESSIONREJECTREASON_SendingTimeAccuracy = "10";

    public static final String SESSIONREJECTREASON_InvalidMsgType = "11";

    public static final String SESSIONREJECTREASON_XMLValidationError = "12";

    public static final String SESSIONREJECTREASON_TagDuplicated = "13";

    public static final String SESSIONREJECTREASON_TagOutOfOrder = "14";

    public static final String SESSIONREJECTREASON_RepeatingFieldsOutOfOrder = "15";

    public static final String SESSIONREJECTREASON_IncorrectNumInGroup = "16";

    public static final String SESSIONREJECTREASON_NonDataValueIncludesDelimiter = "17";

    public static final String SESSIONREJECTREASON_Other = "99";

    public static final String SETTLINSTMODE_Default = "0";

    public static final String SETTLINSTMODE_StandingInstructionsProvided = "1";

    public static final String SETTLINSTMODE_SpecificAllocationAccountOverriding = "2";

    public static final String SETTLINSTMODE_SpecificAllocationAccountStanding = "3";

    public static final String SETTLINSTMODE_SpecificOrderForASingleAccount = "4";

    public static final String SETTLINSTMODE_RequestReject = "5";

    public static final String SIDE_Buy = "1";

    public static final String SIDE_Sell = "2";

    public static final String SIDE_BuyMinus = "3";

    public static final String SIDE_SellPlus = "4";

    public static final String SIDE_SellShort = "5";

    public static final String SIDE_SellShortExempt = "6";

    public static final String SIDE_Undisclosed = "7";

    public static final String SIDE_Cross = "8";

    public static final String SIDE_CrossShort = "9";

    public static final String SIDE_CrossShortExempt = "A";

    public static final String SIDE_AsDefined = "B";

    public static final String SIDE_Opposite = "C";

    public static final String SUBSCRIPTIONREQUESTTYPE_Snapshot = "0";

    public static final String SUBSCRIPTIONREQUESTTYPE_Subscribe = "1";

    public static final String SUBSCRIPTIONREQUESTTYPE_Unsubscribe = "2";

    public static final String TIMEINFORCE_Day = "0";

    public static final String TIMEINFORCE_GoodTillCancel = "1";

    public static final String TIMEINFORCE_AtOpening = "2";

    public static final String TIMEINFORCE_ImmediateOrCancel = "3";

    public static final String TIMEINFORCE_FillOrKill = "4";

    public static final String TIMEINFORCE_GoodTillCrossing = "5";

    public static final String TIMEINFORCE_GoodTillDate = "6";

    public static final String TIMEINFORCE_AtClose = "7";

    public static final String TRADSESSTATUS_Unknown = "0";

    public static final String TRADSESSTATUS_Halted = "1";

    public static final String TRADSESSTATUS_Open = "2";

    public static final String TRADSESSTATUS_Closed = "3";

    public static final String TRADSESSTATUS_PreOpen = "4";

    public static final String TRADSESSTATUS_PreClose = "5";

    public static final String TRADSESSTATUS_RequestRejected = "6";

    public static final String TRADEALLOCINDICATOR_AllocationNotRequired = "0";

    public static final String TRADEALLOCINDICATOR_AllocationRequired = "1";

    public static final String TRADEALLOCINDICATOR_UseAllocationProvidedWithTrade = "2";

    public static final String EMXTAGAccountReference = "9400";

    public static final String EMXTAGAgencyNumber = "9494";

    public static final String EMXTAGCancellationRightsFlag = "9422";

    public static final String EMXTAGCardholderName = "9437";

    public static final String EMXTAGCardExpiryDate = "9439";

    public static final String EMXTAGCardIssueNumber = "9440";

    public static final String EMXTAGCardNumber = "9438";

    public static final String EMXTAGCardStartDate = "9492";

    public static final String EMXTAGCertificate = "9479";

    public static final String EMXTAGClientReference = "1";

    public static final String EMXTAGClientShortName = "9444";

    public static final String EMXTAGCommissionCurrencyCode = "9418";

    public static final String EMXTAGCommissionPercentage = "9431";

    public static final String EMXTAGCommissionValue = "12";

    public static final String EMXTAGCommissionWaivedPercentage = "9419";

    public static final String EMXTAGCommissionWaivedType = "9474";

    public static final String EMXTAGCorrespondenceAddress = "9412";

    public static final String EMXTAGDateOfBirth = "9435";

    public static final String EMXTAGDealCurrencyCode = "9455";

    public static final String EMXTAGDealReference = "9456";

    public static final String EMXTAGDealSequenceNumber = "67";

    public static final String EMXTAGDealValuationPointTimestamp = "60";

    public static final String EMXTAGDesignation = "9449";

    public static final String EMXTAGDigitalSignature = "9480";

    public static final String EMXTAGDigitalSignatureTime = "9481";

    public static final String EMXTAGDilutionLevy = "9457";

    public static final String EMXTAGDilutionLevyPercentage = "9465";

    public static final String EMXTAGDiscount = "9432";

    public static final String EMXTAGDiscountPercentage = "9433";

    public static final String EMXTAGDistributionAccountName = "9489";

    public static final String EMXTAGDistributionAccountNumber = "9484";

    public static final String EMXTAGDistributionBankName = "9482";

    public static final String EMXTAGDistributionCurrencyCode = "9417";

    public static final String EMXTAGDistributionPaymentReference = "9485";

    public static final String EMXTAGDistributionSortCode = "9483";

    public static final String EMXTAGConversationID = "9491";

    public static final String EMXTAGProviderID = "9490";

    public static final String EMXTAGErrorCode = "9427";

    public static final String EMXTAGExitCharge = "9434";

    public static final String EMXTAGExitChargeCurrencyCode = "9454";

    public static final String EMXTAGFirstAttemptTimeStamp = "9452";

    public static final String EMXTAGForeignExchangeRate = "155";

    public static final String EMXTAGForeignExchangeRateFlag = "156";

    public static final String EMXTAGForexRequiredFlag = "121";

    public static final String EMXTAGForwardedMessageFlag = "9476";

    public static final String EMXTAGFundBasedRenewalPercentage = "9459";

    public static final String EMXTAGFundBasedRenewalValue1 = "9461";

    public static final String EMXTAGFundBasedRenewalValue2 = "9463";

    public static final String EMXTAGFundBasedRenewalWaived = "9475";

    public static final String EMXTAGFundID = "48";

    public static final String EMXTAGFundIDType = "22";

    public static final String EMXTAGGroupOneOrTwoIndicator = "9443";

    public static final String EMXTAGIncomeDestinationFlag = "9416";

    public static final String EMXTAGInitialCharge = "9458";

    public static final String EMXTAGISAType = "9451";

    public static final String EMXTAGMailingInformationText = "9424";

    public static final String EMXTAGMessageID = "9426";

    public static final String EMXTAGMoneyLaunderingStatusFlag = "9423";

    public static final String EMXTAGMovementType = "54";

    public static final String EMXTAGNINO = "9436";

    public static final String EMXTAGNumberOfDealsInOrder = "68";

    public static final String EMXTAGNumberOfRegisteredHolders = "9403";

    public static final String EMXTAGNumberOfUnitsBoughtOrSold = "9478";

    public static final String EMXTAGOrderCashAmount = "152";

    public static final String EMXTAGOrderQuantity = "38";

    public static final String EMXTAGOrderUnits = "9495";

    public static final String EMXTAGOrderQuantityPercentage = "9402";

    public static final String EMXTAGOrderReference = "11";

    public static final String EMXTAGOrderType = "9401";

    public static final String EMXTAGOriginalMessageID = "9467";

    public static final String EMXTAGOriginalMessageSequenceNumber = "9466";

    public static final String EMXTAGOriginalReference = "9472";

    public static final String EMXTAGOriginalSequence = "9473";

    public static final String EMXTAGOriginalTagID = "9445";

    public static final String EMXTAGOriginatorID = "9488";

    public static final String EMXTAGPrice = "44";

    public static final String EMXTAGPriceBasisCode = "9462";

    public static final String EMXTAGPriceCurrencyCode = "15";

    public static final String EMXTAGPriceType = "9430";

    public static final String EMXTAGProjectedFundValue = "9460";

    public static final String EMXTAGProvidersProduct = "9442";

    public static final String EMXTAGReceivedTimestamp = "9425";

    public static final String EMXTAGRegistrationAddress1 = "9408";

    public static final String EMXTAGRegistrationAddress2 = "9409";

    public static final String EMXTAGRegistrationAddress3 = "9410";

    public static final String EMXTAGRegistrationAddress4 = "9411";

    public static final String EMXTAGRegistrationName1 = "9404";

    public static final String EMXTAGRegistrationName2 = "9405";

    public static final String EMXTAGRegistrationName3 = "9406";

    public static final String EMXTAGRegistrationName4 = "9407";

    public static final String EMXTAGRounding = "9420";

    public static final String EMXTAGSafeKeepingSubAccount = "173";

    public static final String EMXTAGSafeKeepingAccount = "174";

    public static final String EMXTAGSendTime = "52";

    public static final String EMXTAGSentTimestamp = "9453";

    public static final String EMXTAGSettlementAccountName = "185";

    public static final String EMXTAGSettlementAccountNumber = "184";

    public static final String EMXTAGSettlementBankName = "182";

    public static final String EMXTAGSettlementConsideration = "119";

    public static final String EMXTAGSettlementCurrencyCode = "9414";

    public static final String EMXTAGSettlementDate = "64";

    public static final String EMXTAGSettlementPaymentMethodCode = "9441";

    public static final String EMXTAGSettlementPaymentReference = "9415";

    public static final String EMXTAGSettlementSortCode = "183";

    public static final String EMXTAGSettlementType = "63";

    public static final String EMXTAGSpecialCommission = "9471";

    public static final String EMXTAGSwitchDriverIndicator = "9468";

    public static final String EMXTAGText = "58";

    public static final String EMXTAGTopUpOrWithdrawIndicator = "9421";

    public static final String EMXTAGTotalNumberOfValuations = "9450";

    public static final String EMXTAGTransactionReference = "37";

    public static final String EMXTAGTransactionBookedTimestamp = "9428";

    public static final String EMXTAGTransactionPointTimestamp = "60";

    public static final String EMXTAGUKResident = "9413";

    public static final String EMXTAGValuationAccountReference = "9487";

    public static final String EMXTAGValuationClientReference = "9486";

    public static final String EMXTAGValuationCurrencyCode = "15";

    public static final String EMXTAGValuationPointTimestamp = "9429";

    public static final String EMXTAGValuationPrice = "132";

    public static final String EMXTAGValuationProvidersProduct = "9493";

    public static final String EMXTAGValuationReference = "131";

    public static final String EMXTAGValuationRequestTimestamp = "9464";

    public static final String EMXTAGValuationResponseReference = "117";

    public static final String EMXTAGValuationResponseSequence = "9477";

    public static final String EMXTAGValuationSequenceNumber = "9470";

    public static final String EMXTAGValuationSettledQuantity = "9446";

    public static final String EMXTAGValuationType = "9469";

    public static final String EMXTAGValuationUnsettledQuantity = "9448";

    public static final String EMXTAGValuationValue = "9447";

}
