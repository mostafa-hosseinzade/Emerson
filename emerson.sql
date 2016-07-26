-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 26, 2016 at 05:09 PM
-- Server version: 5.5.50-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `emerson`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand_emerson`
--

CREATE TABLE IF NOT EXISTS `brand_emerson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_en` longtext COLLATE utf8_unicode_ci,
  `content_fa` longtext COLLATE utf8_unicode_ci,
  `created_at` datetime DEFAULT NULL,
  `link` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `brand_emerson`
--

INSERT INTO `brand_emerson` (`id`, `content_en`, `content_fa`, `created_at`, `link`, `title_en`, `title_fa`, `updated_at`) VALUES
(1, 'Brand 1', 'برند ۱', '2016-07-20 16:21:07', '', 'Brand 1', 'برند ۱', NULL),
(2, 'Brand 2', 'برند ۲', '2016-07-20 16:21:30', '', 'Brand 2', 'برند ۲', NULL),
(3, 'Brand 3', 'برند ۳', '2016-07-20 16:23:15', '', 'Brand 3', 'برند ۳', NULL),
(4, 'Brand 4', 'برند ۴', '2016-07-20 16:23:31', '', 'Bran 4', 'برند ۴', '2016-07-20 16:32:26'),
(5, 'Brand 5', 'برند ۵', '2016-07-20 16:23:50', '', 'Brand 5', 'برند ۵', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `section` longtext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `created_at`, `email`, `message`, `name`, `phone`, `section`) VALUES
(1, '2016-07-26 16:03:01', 'test@test.test', 'test', 'test', '02135565656', NULL),
(2, '2016-07-26 16:40:47', 'test@test.test', 'test', 'test', '02135685745', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_en` longtext COLLATE utf8_unicode_ci,
  `content_fa` longtext COLLATE utf8_unicode_ci,
  `created_at` datetime DEFAULT NULL,
  `img` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `meta` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `visit` int(11) DEFAULT NULL,
  `ctg_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_news_ctg_id` (`ctg_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `content_en`, `content_fa`, `created_at`, `img`, `meta`, `slug`, `title_en`, `title_fa`, `updated_at`, `visit`, `ctg_id`) VALUES
(1, 'test', 'test', '2016-07-17 09:53:13', '1_1469528930237.jpg', 'test', 'test', 'test', 'test', '2016-07-26 14:58:50', 0, 1),
(2, 'test2', 'test2', '2016-07-17 09:53:36', '1_1469528923083.jpg', 'test2', 'test2', 'test2', 'test2', '2016-07-26 14:58:43', 2, 1),
(3, 'test', 'test', '2016-07-17 10:00:53', '1_1469528912742.jpg', 'test', 'test', 'test2', 'test', '2016-07-26 14:58:32', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `news_category`
--

CREATE TABLE IF NOT EXISTS `news_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `describtion_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `describtion_fa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `img` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `news_category`
--

INSERT INTO `news_category` (`id`, `created_at`, `describtion_en`, `describtion_fa`, `img`, `title_en`, `title_fa`, `updated_at`) VALUES
(1, '2016-07-26 14:02:38', 'Piramoon News Category', 'Piramoon News Category', '1_1469526372208.jpg', 'Piramoon', 'پبرامون', '2016-07-26 14:16:12'),
(2, '2016-07-26 14:03:08', 'Emerson News', 'Emerson News', '1_1469526350627.jpg', 'Emerson', 'امرسون', '2016-07-26 14:15:50');

-- --------------------------------------------------------

--
-- Table structure for table `page`
--

CREATE TABLE IF NOT EXISTS `page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_en` longtext COLLATE utf8_unicode_ci,
  `content_fa` longtext COLLATE utf8_unicode_ci,
  `craeted_at` datetime DEFAULT NULL,
  `CREATEDAT` datetime DEFAULT NULL,
  `img` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `meta` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `visit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `page`
--

INSERT INTO `page` (`id`, `content_en`, `content_fa`, `craeted_at`, `CREATEDAT`, `img`, `meta`, `slug`, `title_en`, `title_fa`, `updated_at`, `visit`) VALUES
(3, '<div class="item-page" itemscope="" itemtype="https://schema.org/Article">\r\n	<meta itemprop="inLanguage" content="en-GB">\r\n	\r\n		\r\n			<div class="page-header">\r\n					<h2 itemprop="name">\r\n				Piramoon Palai Engineering			</h2>\r\n									</div>\r\n							\r\n<div class="icons">\r\n	\r\n					<div class="btn-group pull-right">\r\n				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <span class="icon-cog"></span><span class="caret"></span> </a>\r\n								<ul class="dropdown-menu">\r\n											<li class="print-icon"> <a href="/index.php/piramoon-palai-engineering?tmpl=component&amp;print=1&amp;page=" title="Print" onclick="window.open(this.href,''win2'',''status=no,toolbar=no,scrollbars=yes,titlebar=no,menubar=no,resizable=yes,width=640,height=480,directories=no,location=no''); return false;" rel="nofollow"><span class="icon-print"></span>Print</a> </li>\r\n																<li class="email-icon"> <a href="/index.php/component/mailto/?tmpl=component&amp;template=corpway&amp;link=00f6e79fb3f40063fe1b20d91d930194185fef64" title="Email" onclick="window.open(this.href,''win2'',''width=400,height=350,menubar=yes,resizable=yes''); return false;" rel="nofollow"><span class="icon-envelope"></span>Email</a> </li>\r\n														</ul>\r\n			</div>\r\n		\r\n	</div>\r\n			\r\n	\r\n	\r\n				\r\n								<div itemprop="articleBody">\r\n		<p style="text-align: justify;">On behalf of the Piramoon Engineering Group, I would like to extend my sincere appreciation for your cooperation with us for the past 15 years.&nbsp; The Piramoon Engineering Group, with its upscale growth by relying on committed shareholders, and highly qualified and specialized associates, has embraced the addition of Piramoon System Qeshm (PSQ), and Piramoon Pardazesh (PLC).</p>\r\n<p style="text-align: justify;">Our superb products and services by utilizing immaculate workmanship, and proficiency have sketched the template for our growth plan.&nbsp; Empowered engineering, sustainable growth, reliable warranty and services, and our client’s trust has helped us to be a unique company.</p>\r\n<p style="text-align: justify;">This empowered capability has become a life line of the diligence and assiduity of the shareholders and employees, and client’s confidence.</p>\r\n<p>Piramoon Palai Engineering group is dedicated to restless work and ever growing pattern to make us a confident and Credence Company.</p>\r\n<p>&nbsp;</p>\r\n<p>Sincerely Yours,</p>\r\n<p>&nbsp;</p>\r\n<p>Alireza Niktab Eta’ati</p>\r\n<p>Piramoon Palai Engineering Co. Ltd.</p>\r\n<p>Cofounder and CEO</p>\r\n<p>&nbsp;</p>\r\n<p><strong>&nbsp;Our Partners</strong></p>\r\n\r\n\r\n<div class="nn_tabs outline_handles outline_content align_left top has_effects">\r\n<a name="nn_tabs-scrollto_1" class="anchor nn_tabs-scroll"></a>\r\n<ul class="nav nav-tabs" id="set-nn_tabs-1">\r\n<li class="nn_tabs-tab active">\r\n<a href="#hsme" class="nn_tabs-toggle" data-toggle="tab" data-id="hsme"><span class="nn_tabs-toggle-inner">HSME</span></a>\r\n</li>\r\n<li class="nn_tabs-tab">\r\n<a href="#centec" class="nn_tabs-toggle" data-toggle="tab" data-id="centec"><span class="nn_tabs-toggle-inner">Centec</span></a>\r\n</li>\r\n<li class="nn_tabs-tab">\r\n<a href="#others" class="nn_tabs-toggle" data-toggle="tab" data-id="others"><span class="nn_tabs-toggle-inner">others</span></a>\r\n</li>\r\n</ul>\r\n<div class="tab-content">\r\n<div class="tab-pane nn_tabs-pane active" id="hsme">\r\n<h2 class="nn_tabs-title"><a name="hsme" class="anchor"></a>HSME</h2>\r\n<p><img src="/images/HSMElogo.jpg" alt="" width="181" height="86"></p>\r\n<p>Piramoon’s main concern is quality and innovation. Due to the extensive experience with different manufacturers and the need of a reputable supply chain of valves, fittings and subsystems for Instrumentation, Hydraulic, Shipbuilding and Diesel Engine Industries, Piramoon Palai Engineering company with more than 15 years of experience selected HSME corporation for this range of products.&nbsp;</p>\r\n<p>For the past 4 decades HSME have gained excellent recognition from clients including Hyundai Heavy Industries, Daewoo Shipbuilding &amp; Marine Engineering, STX Offshore, Man Diesel &amp; Turbo, Wartsila, and Doosan Heavy Industry.</p>\r\n<p>Please visit the page <span style="color: #0000ff;"><em><strong><a style="color: #0000ff;" href="http://www.hsmecorp.com/">http://www.hsmecorp.com</a></strong></em></span>&nbsp;and/or submit any query to<span style="color: #0000ff;"> <em><strong>p.taheri@ piramoonco.com</strong></em></span> or directly to <span style="color: #0000ff;"><em><strong>HSME @HSMEcorp.com</strong></em></span></p>\r\n<p>Our colleagues at Piramoon will be pleased to provide the needed information,</p>\r\n<p>please drop us a line or give us a call at <em><strong>+98 21 44 44 49 50 ext: 407</strong></em></p>\r\n<p>&nbsp;</p>\r\n\r\n\r\n</div>\r\n<div class="tab-pane nn_tabs-pane" id="centec">\r\n<h2 class="nn_tabs-title"><a name="centec" class="anchor"></a>Centec</h2>\r\n<p><img src="/images/centec.jpg" alt=""></p>\r\n<p>Our major involvement at Piramoon Group has been in the energy industries, at the same time we have been pursuing other potential markets. Some of the main industries are food, beverages, dairy products, and pharmaceuticals which they could be a great addition to extended fields of our activities.We have partnered</p>\r\n<p>with the Centec Group, a leading company to help us better serve the said industries.</p>\r\n<p>Centec is the only Skid manufacturer which builds their own sensors.</p>\r\n<p>submit your inquiry or&nbsp;ask for more information by centec @ piramoonco.com</p>\r\n<p>more info :&nbsp;<em><strong><a href="http://www.centec.de/en/products/" rel="alternate">centec webpage</a></strong></em></p>\r\n<p>&nbsp;</p>\r\n\r\n\r\n</div>\r\n<div class="tab-pane nn_tabs-pane" id="others">\r\n<h2 class="nn_tabs-title"><a name="others" class="anchor"></a>others</h2>\r\n<p>&amp;...</p>\r\n</div></div></div> 	</div>\r\n\r\n	\r\n							</div>\r\n', '<div class="item-page" itemscope="" itemtype="https://schema.org/Article">\r\n	<meta itemprop="inLanguage" content="fa-IR">\r\n	\r\n		\r\n			<div class="page-header">\r\n					<h2 itemprop="name">\r\n				پیرامون پالای قشم			</h2>\r\n									</div>\r\n							\r\n<div class="icons">\r\n	\r\n					<div class="btn-group pull-right">\r\n				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <span class="icon-cog"></span><span class="caret"></span> </a>\r\n								<ul class="dropdown-menu">\r\n											<li class="print-icon"> <a href="/fa/index.php/piramoon-palai-engineering?tmpl=component&amp;print=1&amp;page=" title="پرینت" onclick="window.open(this.href,''win2'',''status=no,toolbar=no,scrollbars=yes,titlebar=no,menubar=no,resizable=yes,width=640,height=480,directories=no,location=no''); return false;" rel="nofollow"><span class="icon-print"></span>پرینت</a> </li>\r\n																<li class="email-icon"> <a href="/fa/index.php/component/mailto/?tmpl=component&amp;template=corpway&amp;link=93069bb3da9810d14b6ec8db18442c03561a0bb6" title="ایمیل" onclick="window.open(this.href,''win2'',''width=400,height=350,menubar=yes,resizable=yes''); return false;" rel="nofollow"><span class="icon-envelope"></span>ایمیل</a> </li>\r\n														</ul>\r\n			</div>\r\n		\r\n	</div>\r\n			\r\n	\r\n	\r\n				\r\n								<div itemprop="articleBody">\r\n		<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">هم اکنون شرکت مهندسی پیرامون پالای بعنوان شرکت مادر، فراهمی&nbsp;امکانات زیرساختی را برای شرکتهای همکار خود در دستور کار&nbsp;داشته و در کمال مسرت بخشهایی را که از ابتدا بر آن تاکید داشته با&nbsp;جدیت پیگیری می نماید.&nbsp;راهکارهای مدیریتی و مهندسی در فرآیندهای صنعتی، زیست محیطی&nbsp;و ایمنی با ارائه شیوه ها و سیستمهای به روز و توانمند که نتیجه سالها&nbsp;تبحر و همراهی با پیشتازان جهان است در اختیار صنایع انرژی کشورقرار خواهد داد.</span></p>\r\n<p style="text-align: justify;">&nbsp;</p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">تمرکز فعالیت مجموعه پیرامون بر صنایع انرژی از ابتدای تاسیس مانع از ارائه خدمات به صنایع کوچکتر و در حال توسعه نبوده است.</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">صنایع داروسازی، زیست فن آوری، شیر و فراوردهای آن، غذایی و نوشیدنی های غیرالکلی در حال توسعه بازار خود بوده و تکیه بر کیفیت را بهترین راه</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">ماندگاری، پیشتازی و رقابت در بازار می دانند.</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">از اینرو برای همراهی هر چه بیشتر با صنایع ایران در ارتقای کیفیت، بهبود فرآیندها و نهایتا سهم از بازار، مجموعه پیرامون همکاری خود را با پیشتازان صنعت</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">جهانی که دارای سوابق درخشان می باشند را سرلوحه کار خود قرار داده است.</span></p>\r\n<p style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;"></span></p>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal;"><strong>شرکت های همکار</strong></p>\r\n\r\n\r\n<div class="nn_tabs outline_handles outline_content align_right top has_effects">\r\n<a name="nn_tabs-scrollto_1" class="anchor nn_tabs-scroll"></a>\r\n<ul class="nav nav-tabs" id="set-nn_tabs-1">\r\n<li class="nn_tabs-tab active">\r\n<a href="#centec" class="nn_tabs-toggle" data-toggle="tab" data-id="centec"><span class="nn_tabs-toggle-inner">Centec</span></a>\r\n</li>\r\n<li class="nn_tabs-tab">\r\n<a href="#msr" class="nn_tabs-toggle" data-toggle="tab" data-id="msr"><span class="nn_tabs-toggle-inner"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 13.3333330154419px; line-height: 25.5999984741211px; text-align: justify;">MSR</span></span></a>\r\n</li>\r\n<li class="nn_tabs-tab">\r\n<a href="#others" class="nn_tabs-toggle" data-toggle="tab" data-id="others"><span class="nn_tabs-toggle-inner">others</span></a>\r\n</li>\r\n</ul>\r\n<div class="tab-content">\r\n<div class="tab-pane nn_tabs-pane active" id="centec">\r\n<h2 class="nn_tabs-title"><a name="centec" class="anchor"></a>Centec</h2>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal;"><img src="/fa/images/centec.jpg" alt=""></p>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal;">&nbsp;</p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">شرکت CENTEC آلمان از معدود شرکتهایی است که طراحی و ساخت اسکید SKID ها را با سنسورهایی که خود طراح و سازنده آنهاست، ارائه می نماید.</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">سنسورهای آزمایشگاهی و صنعتی شرکت Centec برای اندازه گیری های زیر می باشد:</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">1- اکسیژن محلول OXYTRANS</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">2 -دی اکسید کربن محلول CARBOTEC</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">3 -غلظت سنج شکر، الکل، اسید یا باز SONATEC, RHEOTEC &amp; COMBITEC</span></p>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;"></span></p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">از دیگر توانمندیهای شرکت Centec طراحی و ساخت اسکیدهای Skids صنعتی در&nbsp;کاربردهای فرایندی ویژه می باشد که بر اساس نیاز و سفارش مشتری طراحی و ساخته&nbsp;می شوند. کاربردهایی همچون:</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">1) تخلیص آب: تصفیه و جداسازی مواد معدنی با روشهای اسمز معکوس، گند زدایی و&nbsp;تقطیر حتی در حد آبهای قابل تزریق &nbsp;Water For Injection &nbsp;(<span style="line-height: 25.5999984741211px;">WFI</span>)</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">2) آب و هوا زدایی محصول برای کاهش میزان اکسیژن و CO2 محلول</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">3) گازدهی به مایعات کربندار (Carbonizing) و نیتروژن دار Nitrogenizing کردن&nbsp;نوشیدنی های غیرالکلی، مالت، ماءالشعیر و آب</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">4) مخلوط کردن بر اساس سنجش و تزریق میزان دقیق افزودنی ها D osing Blending</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">که در رقیق کردن محلولهای قندی غلیظ و مخلوط کردن مواد آرایشی و شیمیایی کاربردی&nbsp;گسترده دارند.</span></p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">5) فیلتراسیون استریل محصول،پاستوریزاسیون به روشهای&nbsp;<span style="line-height: 25.5999984741211px;">CIP</span></span></p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">6) حذف و بازیابی الکل Dealcoholization از نوشیدنیهای تخمیری بروش تقطیر&nbsp;در خلا&nbsp;دفتر مرکزی، مهندسی، طراحی و کنترل کیفیت همچنین ساخت سنسورهای شرکت&nbsp;Centec در آلمان و ساخت اسکیدها و خطوط تولید در کارخانه واقع در جمهوری چک&nbsp;صورت می پذیرد.شرکت مهندسی پیرامون پالای با 15 سال سابقه کار در زمینه ی سیستمهای ابزار دقیق و&nbsp;آنالایزر صنایع نقت و گاز و پتروشیمی و بعنوان اولین و بزرگترین سازنده سیستمهای آنالیز&nbsp;آنلاین در کشور به عنوان نماینده ی انحصاری Centec در ایران برترین خدمات جامع از&nbsp;مجموعه پیرامون و Centec تا بهره برداری سیستم ها را تضمین می نماید.&nbsp;برای دستیابی به اطلاعات بیشتر به لینک های مربوطه رجوع فرمایید و یا با کارشناس این&nbsp;شرکت <span style="color: #3366ff;"><span id="cloak85788"><a href="mailto:centec@piramoonco.com">centec@piramoonco.com</a></span>&lt;script type="text/javascript"&gt;\r\n //<!--\r\n document.getElementById(''cloak85788'').innerHTML = '''';\r\n var prefix = ''&#109;a'' + ''i&#108;'' + ''&#116;o'';\r\n var path = ''hr'' + ''ef'' + ''='';\r\n var addy85788 = ''c&#101;nt&#101;c'' + ''&#64;'';\r\n addy85788 = addy85788 + ''p&#105;r&#97;m&#111;&#111;nc&#111;'' + ''&#46;'' + ''c&#111;m'';\r\n var addy_text85788 = ''c&#101;nt&#101;c'' + ''&#64;'' + ''p&#105;r&#97;m&#111;&#111;nc&#111;'' + ''&#46;'' + ''c&#111;m'';\r\n document.getElementById(''cloak85788'').innerHTML += ''<a '' + path + ''\\'''' + prefix + '':'' + addy85788 + ''\\''>''+addy_text85788+''<\\/a>'';\r\n //-->\r\n &lt;/script&gt;</span> تماس حاصل فرمایید.</span></p>\r\n<p>&nbsp;</p>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal;">&nbsp;</p>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal;">&nbsp;</p>\r\n\r\n\r\n</div>\r\n<div class="tab-pane nn_tabs-pane" id="msr">\r\n<h2 class="nn_tabs-title"><a name="msr" class="anchor"></a>MSR</h2>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal; text-align: justify;">&nbsp;</p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-size: 10pt;"><span style="font-family: tahoma, arial, helvetica, sans-serif;">شرکت مهندسی پیرامون پالای پس از سالها تجربه موفق در توسعه سیستمهای ابزاردقیق و آنالایزر در ایران همکاری با شرکت MSR ELECTRONIC آلمان&nbsp;را در راستای تامین برترین و مطمئن ترین سنسورها، سیستمهای ایمنی، حفاظتی و هشدار آغاز نموده است تا با تکیه برشبکه توانمند فنی – مهندسی و خدمات&nbsp;پس از فروش حفاظت از گرانمایه ترین سرمایه یعنی نیروی انسانی و سپس تاسیسات صنعتی و ساختمانی بکار بندد.&nbsp;شرکت MSR ELECTRONIC بیش از 25 سال است که فن آوریهای حفاظتی را توسعه می دهد. حسگر ) Sensors ( ها ی کاملا اختصاصی، کنترلرها&nbsp;و تجهیزات هشداردهنده بصور مختلف را کنار یکدیگر قرار می دهد تا ترکیبهای مختلفی از سامانه های پایش – هشدار Monitoring &amp; Warning&nbsp;Systems را برای شرایط اظطراری و خطرناک تامین نمایند.&nbsp;MSR بدلیل کیفیت برتر و مطمئن، سادگی عملکرد، رقابتی بودن هزینه ها، گستره کامل محصولات و نوآوری های ارزشمند از پیشتازان جهان ایمنی است که&nbsp;با همراهی شرکت مهندسی پیرامون پالای از سال 1394 فعالیت خود در ایران را آغاز نموده است.</span></span></p>\r\n\r\n\r\n</div>\r\n<div class="tab-pane nn_tabs-pane" id="others">\r\n<h2 class="nn_tabs-title"><a name="others" class="anchor"></a>others</h2>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal;">&amp;...</p>\r\n</div></div></div> 	</div>\r\n\r\n	\r\n							</div>\r\n', NULL, '2016-07-26 16:24:47', '1_1469534087678.jpg', 'پیرامون پالای قشم', 'Piramoon-Palay', 'Piramoon Palai Engineering', 'پیرامون پالای قشم', NULL, 0),
(4, '<div class="item-page" itemscope="" itemtype="https://schema.org/Article">\r\n	<meta itemprop="inLanguage" content="en-GB">\r\n	\r\n		\r\n			<div class="page-header">\r\n					<h2 itemprop="name">\r\n				Piramoon Pardazesh			</h2>\r\n									</div>\r\n							\r\n<div class="icons">\r\n	\r\n					<div class="btn-group pull-right">\r\n				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <span class="icon-cog"></span><span class="caret"></span> </a>\r\n								<ul class="dropdown-menu">\r\n											<li class="print-icon"> <a href="/index.php/piramoon-pardazesh?tmpl=component&amp;print=1&amp;page=" title="Print" onclick="window.open(this.href,''win2'',''status=no,toolbar=no,scrollbars=yes,titlebar=no,menubar=no,resizable=yes,width=640,height=480,directories=no,location=no''); return false;" rel="nofollow"><span class="icon-print"></span>Print</a> </li>\r\n																<li class="email-icon"> <a href="/index.php/component/mailto/?tmpl=component&amp;template=corpway&amp;link=cd5b4b1ea49ae56bc5f8c932eb4d077a62f7416a" title="Email" onclick="window.open(this.href,''win2'',''width=400,height=350,menubar=yes,resizable=yes''); return false;" rel="nofollow"><span class="icon-envelope"></span>Email</a> </li>\r\n														</ul>\r\n			</div>\r\n		\r\n	</div>\r\n			\r\n	\r\n	\r\n				\r\n								<div itemprop="articleBody">\r\n		<p style="text-align: justify;">Our latest addition to the Piramoon Engineering Group, the Piramoon Pardezesh Qeshm established in 2014 in the Qeshm Free Zone, providing control system, measurement instruments, valves and regulators for the oil and gas industry, petrochemical, steel, mining, pharmaceutical and car manufacturing.</p>\r\n<p style="text-align: justify;">Environmental control system parameters for water and sewage plants monitoring system are considered to be part of our endeavors.</p>\r\n<p style="text-align: justify;">&nbsp;The Piramoon Pardazesh rested on its specialized, trained, and competent personnel, with full recognition of industrial process, produces the said projects in the least amount of time and uses the latest technological innovations.</p>\r\n<p>The Piramoon Pardazesh sectors are defined as:</p>\r\n<ul>\r\n<li><strong><a href="/index.php/service/analysis-packages/control-systems" target="_blank" rel="alternate">Control System</a></strong></li>\r\n<li><strong><a href="/index.php/service/s5-tab-show/valves-regulators" target="_blank" rel="alternate">Valves and Regulators</a></strong></li>\r\n<li>Instrumentation &amp; Measurement</li>\r\n<li><strong><a href="/index.php/service/analysis-packages/metering-systems" target="_blank" rel="alternate">Metering System</a></strong></li>\r\n<li><strong><a href="/index.php/service/analysis-packages/control-systems" target="_blank" rel="alternate">HIPPS Package</a></strong></li>\r\n</ul> 	</div>\r\n\r\n	\r\n							</div>', '<div class="item-page" itemscope="" itemtype="https://schema.org/Article">\r\n	<meta itemprop="inLanguage" content="fa-IR">\r\n	\r\n		\r\n			<div class="page-header">\r\n					<h2 itemprop="name">\r\n				پیرامون پردازش قشم 			</h2>\r\n									</div>\r\n							\r\n<div class="icons">\r\n	\r\n					<div class="btn-group pull-right">\r\n				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <span class="icon-cog"></span><span class="caret"></span> </a>\r\n								<ul class="dropdown-menu">\r\n											<li class="print-icon"> <a href="/fa/index.php/piramoon-pardazesh?tmpl=component&amp;print=1&amp;page=" title="پرینت" onclick="window.open(this.href,''win2'',''status=no,toolbar=no,scrollbars=yes,titlebar=no,menubar=no,resizable=yes,width=640,height=480,directories=no,location=no''); return false;" rel="nofollow"><span class="icon-print"></span>پرینت</a> </li>\r\n																<li class="email-icon"> <a href="/fa/index.php/component/mailto/?tmpl=component&amp;template=corpway&amp;link=c40279c6899731af99c22a5da2a8d25f41dfb03c" title="ایمیل" onclick="window.open(this.href,''win2'',''width=400,height=350,menubar=yes,resizable=yes''); return false;" rel="nofollow"><span class="icon-envelope"></span>ایمیل</a> </li>\r\n														</ul>\r\n			</div>\r\n		\r\n	</div>\r\n			\r\n	\r\n	\r\n				\r\n								<div itemprop="articleBody">\r\n		<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">در راستای تخصصی نمودن شرکتهای زیر مجموعه و نیاز بازار آتی به سیستمهای کنترل و&nbsp;ابزاردقیق با تکیه بر گذشته ای که در پیرامون پالای و پیرامون سیستم قشم ایجاد گردیده&nbsp;بود، با مشارکت تیم های فعال و جدید شرکت پیرامون پردازش قشم تاسیس گردید.&nbsp;پیرامون پردازش قشم با تکیه بر توان مهندسی، تامین و ساخت سیستمهای کنترل مبتنی بر&nbsp;DCS و سیستمهای میترینگ و ابزاردقیق را در دستور کار خود قرارداده است.&nbsp;الگویی که در مجموعه پیرامون شکل گرفت می رود تا در پیرامون پردازش قشم&nbsp;راهکارهای جدید کنترل و ابزاردقیق و اندازه گیری را به صنایع رو به رشد ایران تقدیم&nbsp;نماید.</span></p>\r\n<p dir="rtl" style="text-align: justify;">&nbsp;</p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">دپارتمان <span dir="LTR">Measurement</span> با قابلیت تامین انواع ترانسمیترهای سنجش جریان حجمی سیالات(<span dir="LTR">Flow Meter</span>) از نوع های <span dir="LTR">DP</span>،<span dir="LTR">Vortex</span>،<span dir="LTR">Magnetic</span> ،<span dir="LTR">Inline ultrasonic</span>،<span dir="LTR">Clamp on Ultrasonic</span> و همجنین سنجش جریان حجمی سیالات (<span dir="LTR">Mass Flow meter</span>)رنج گسترده ای از نیازهای صنایع مختلف به خصوص نفت و گاز و پتروشیمی را پوشش می دهد.</span></p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;"></span><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">واحد فنی این دپارتمان با ارایه دوره های تخصصی در زمینه انواع ترانسمیتر و <span dir="LTR">Tank Gauging</span> و کمک به انتخاب نوع مناسب در شرایط مختلف فرایندی، حمایت فنی از مرحله طراحی تا خرید و خدمات بعد از خرید را به شرکت های پیمانکار و کارفرمایان محترم ارایه می نماید.</span></p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;"></span><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">پشتیبانی فنی دپارتمان <span dir="LTR">Measurement</span> شرکت پیرامون پردازش از مشتریان منجر به انجام پروژه ها با بهترین کیفیت و حداقل زمان و کمترین صرف هزینه های هماهنگی برای مشتری میگردد.ارایه راه حلهای فنی برای موارد خاص فرایندی و بهینه سازی پیشنهادات فنی باعث انجام پروژه ها با بالاترین کارایی می گردد.</span></p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;"></span><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">از دیگر خدمات این دپارتمان تامین قطعات یدکی در مرحله راه اندازی و همچنین دوسالانه می باشد.</span></p>\r\n<p dir="rtl" style="text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;"></span><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;">گشایش اعتبار، خرید، ترخیص و حمل کالا از خدمات بازرگانی این دپارتمان می باشد.</span></p> 	</div>\r\n\r\n	\r\n							</div>', NULL, '2016-07-26 16:35:11', '1_1469534711171.jpg', 'پیرامون پردازش قشم', 'Piramoon-Pardazesh', 'Piramoon Pardazesh', 'پیرامون پردازش قشم', NULL, NULL),
(5, '<div class="item-page" itemscope="" itemtype="https://schema.org/Article">\r\n	<meta itemprop="inLanguage" content="en-GB">\r\n	\r\n		\r\n			<div class="page-header">\r\n					<h2 itemprop="name">\r\n				Piramoon System Qeshm			</h2>\r\n									</div>\r\n							\r\n<div class="icons">\r\n	\r\n					<div class="btn-group pull-right">\r\n				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <span class="icon-cog"></span><span class="caret"></span> </a>\r\n								<ul class="dropdown-menu">\r\n											<li class="print-icon"> <a href="/index.php/piramoon-system-qeshm?tmpl=component&amp;print=1&amp;page=" title="Print" onclick="window.open(this.href,''win2'',''status=no,toolbar=no,scrollbars=yes,titlebar=no,menubar=no,resizable=yes,width=640,height=480,directories=no,location=no''); return false;" rel="nofollow"><span class="icon-print"></span>Print</a> </li>\r\n																<li class="email-icon"> <a href="/index.php/component/mailto/?tmpl=component&amp;template=corpway&amp;link=de67538801d2d092f3d183127d4f4ef0494e1b7f" title="Email" onclick="window.open(this.href,''win2'',''width=400,height=350,menubar=yes,resizable=yes''); return false;" rel="nofollow"><span class="icon-envelope"></span>Email</a> </li>\r\n														</ul>\r\n			</div>\r\n		\r\n	</div>\r\n			\r\n	\r\n	\r\n				\r\n								<div itemprop="articleBody">\r\n		<p style="text-align: justify;"><span style="font-size: 10pt;">Piramoon System Qeshm&nbsp;“PSQ”, inaugurated in February 2007 as a manufacturing&nbsp;and integration&nbsp;facility site for the Piramoon Engineering group in the Qeshm Free Zone. Our first manufactured finished product was an Online Analyzer System, and followed by fabrication of Sampling System. We have achieved the honor to be the top manufacturer and instrumentation of on line Analyzer Systems in the country.</span></p>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">&nbsp;The Piramoon System Qeshm, trying to achieve our market share in the local and regional market. Our objective thrives to deliver and set standards for Quality of service, public relation subjects.</span></p>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">Our company consists of three major groups of water treatment plants and Steam Water cycles Analysis System&nbsp;(SWAS),&nbsp;online process gas analysis systems&nbsp;and continuous emission control system (CEMS).</span></p>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">The Piramoon System Qeshm epigraph is to adhere to the international and national standards.</span></p>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">We, as the only private sector company, is the member of the Petroleum ministry standards to deliberate specialized Analyzer IPN – IN230.</span></p>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">Our potent resume of the projects in the past 7 years to include&nbsp;total sampling systems and integration for&nbsp;analyzer packages of South Pars phase&nbsp;14 with the MAPNA and the IPMI group. Other mentionable successful projects are such as, environmental emission control systems for he phases of 12, 14, 17 and 18&nbsp;of South Pars. The Lorestan and Mahabad petrochemical plants which is inimitable by itself in the country.</span></p>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">Our committed strategy is evolving around research, educate and train our competent associates in this aggressive competitive technological field.</span></p>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">The Piramoon System Qeshm and other Piramoon Engineering group work hand in hand to promote the country’s industry.</span></p>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">&nbsp;</span></p>\r\n<p><strong>&nbsp;Our Partners</strong></p>\r\n\r\n\r\n<div class="nn_tabs outline_handles outline_content align_left top has_effects">\r\n<a name="nn_tabs-scrollto_1" class="anchor nn_tabs-scroll"></a>\r\n<ul class="nav nav-tabs" id="set-nn_tabs-1">\r\n<li class="nn_tabs-tab active">\r\n<a href="#union" class="nn_tabs-toggle" data-toggle="tab" data-id="union"><span class="nn_tabs-toggle-inner">UNION</span></a>\r\n</li>\r\n<li class="nn_tabs-tab">\r\n<a href="#others" class="nn_tabs-toggle" data-toggle="tab" data-id="others"><span class="nn_tabs-toggle-inner">others</span></a>\r\n</li>\r\n</ul>\r\n<div class="tab-content">\r\n<div class="tab-pane nn_tabs-pane active" id="union">\r\n<h2 class="nn_tabs-title"><a name="union" class="anchor"></a>UNION</h2>\r\n<p><img src="http://union-instruments.com/images/logos/Union_Logo_130.png" alt="" width="130" height="122"></p>\r\n<p style="text-align: justify;">Measurement of heat value or the calorific value of the gas is coming to the picture for every industry in Iran. Gas turbine and thermal power plants as the most gas consuming industries, steel industries and every industry that value of heat produced by gas is important for them are looking for this solution.</p>\r\n<p style="text-align: justify;">UNION with about 100 years of high performance in measurement, technology, outstanding accuracy of measurement, quality and maximum security is now representing by Piramoon in Iran.</p>\r\n<p style="text-align: justify;">For more information please visit their website (<em><strong><a href="http://union-instruments.com" target="_blank" rel="alternate">http://union-instruments.com</a></strong></em>), drop an email or query at <span style="color: #0000ff;"><em><strong>info@ piramoonco.com</strong></em></span> or <span style="color: #0000ff;"><em><strong>bernd.renner@ union-instruments.com</strong></em></span>. Piramoon is proud to serve your needs on behalf of <em><strong>UNION</strong> </em>in <em><strong>Iran</strong></em>.</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n\r\n\r\n</div>\r\n<div class="tab-pane nn_tabs-pane" id="others">\r\n<h2 class="nn_tabs-title"><a name="others" class="anchor"></a>others</h2>\r\n<p>&amp;...</p>\r\n</div></div></div>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">&nbsp;</span></p>\r\n<p style="text-align: justify;"><span style="font-size: 10pt;">&nbsp;</span></p> 	</div>\r\n\r\n	\r\n							</div>', '<div class="item-page" itemscope="" itemtype="https://schema.org/Article">\r\n	<meta itemprop="inLanguage" content="fa-IR">\r\n	\r\n		\r\n			<div class="page-header">\r\n					<h2 itemprop="name">\r\n				پیرامون سیستم قشم			</h2>\r\n									</div>\r\n							\r\n<div class="icons">\r\n	\r\n					<div class="btn-group pull-right">\r\n				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <span class="icon-cog"></span><span class="caret"></span> </a>\r\n								<ul class="dropdown-menu">\r\n											<li class="print-icon"> <a href="/fa/index.php/piramoon-system-qeshm?tmpl=component&amp;print=1&amp;page=" title="پرینت" onclick="window.open(this.href,''win2'',''status=no,toolbar=no,scrollbars=yes,titlebar=no,menubar=no,resizable=yes,width=640,height=480,directories=no,location=no''); return false;" rel="nofollow"><span class="icon-print"></span>پرینت</a> </li>\r\n																<li class="email-icon"> <a href="/fa/index.php/component/mailto/?tmpl=component&amp;template=corpway&amp;link=6a3117651a39a67e44630247d4940dfb822f310f" title="ایمیل" onclick="window.open(this.href,''win2'',''width=400,height=350,menubar=yes,resizable=yes''); return false;" rel="nofollow"><span class="icon-envelope"></span>ایمیل</a> </li>\r\n														</ul>\r\n			</div>\r\n		\r\n	</div>\r\n			\r\n	\r\n	\r\n				\r\n								<div itemprop="articleBody">\r\n		<p dir="rtl" style="line-height: 25.5999984741211px; text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt; color: #000000;">پس از تجارب موفق مهندسی پیرامون پالای در زمینه آنالایزرهای&nbsp;آنلاین، شرکت پیرامون سیستم قشم بعنوان بازوی ساخت&nbsp;سیستمهای نمونه برداری و تکمیل سیستمهای آنالیز آنلاین در&nbsp;سال 1386 در منطقه آزاد قشم بنیان گذارده شد.</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt; color: #000000;">پیرامون سیستم قشم امروزه به پیشتاز صنعت آنالیز آنلاین در&nbsp;ایران تبدیل گردیده و امکانات و توانمندیهایی را فراهم نموده&nbsp;است که نه تنها در ایران بلکه در خاور میانه بی نظیر است.</span><br><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt; color: #000000;">مجموعه پیرامون بر زیرساخت مهندسی و طراحی سیستمها تکیه&nbsp;نمود، مدتها با آموزش، راه اندازی و تعمیر و نگهداشت سیستمها&nbsp;در کنار ارائه خدمات قابل توجه، تجارب ارزشمندی را کسب&nbsp;نمود. سپس با تکمیل Integration پکیج های آنالایزر، ساخت&nbsp;قطعات مورد نیاز در سمپلینگ سیستم ها گامهای بعد را برداشت.&nbsp;با کمال افتخار و سربلندی به آرزوی دیرین خود جامه عمل&nbsp;پوشاند و اولین آنالایزر گاز ایرانی را با مشارکت و دانش&nbsp;</span><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt; color: #000000;">فنی پژوهشگاه نیرو بر مبنای MMS تولید نمود. ساخت اولین&nbsp;آنالایزر گازی با مشارکت پژوهشگاه نیرو، گامی است بسیار&nbsp;بزرگ در راستای تحقق وعده تکمیل زنجیره تامین آنالایزرها&nbsp;و خودکفایی کشور.</span></p>\r\n<p dir="rtl" style="line-height: 25.5999984741211px; text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt; color: #000000;">این آنالایزر بزودی پس از کسب تاییدیه های وزارت محترم&nbsp;نیرو و نفت به بازار ارائه خواهند شد.&nbsp;</span></p>\r\n<p dir="rtl" style="line-height: 25.5999984741211px; text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt; color: #000000;">اکنون پیرامون سیستم قشم به تخصصی ترین شرکت ایران در&nbsp;زمینه آنالایزر آنلاین تبدیل گردیده و بدلیل حجم عملیاتی بالا،&nbsp;زمینه های دیگر مرتبط (سیستمهای کنترل، ابزاردقیق، میترینگ&nbsp;و ...) را رها و فقط آنالایزر می سازد اما بهترین را.</span></p>\r\n<p dir="rtl" style="line-height: 25.5999984741211px; text-align: justify;">&nbsp;</p>\r\n<p dir="rtl" style="line-height: 25.5999984741211px; text-align: justify;">&nbsp;</p>\r\n\r\n\r\n<div class="nn_tabs outline_handles outline_content align_right top has_effects">\r\n<a name="nn_tabs-scrollto_1" class="anchor nn_tabs-scroll"></a>\r\n<ul class="nav nav-tabs" id="set-nn_tabs-1">\r\n<li class="nn_tabs-tab active">\r\n<a href="#union" class="nn_tabs-toggle" data-toggle="tab" data-id="union"><span class="nn_tabs-toggle-inner">UNION</span></a>\r\n</li>\r\n<li class="nn_tabs-tab">\r\n<a href="#سایر" class="nn_tabs-toggle" data-toggle="tab" data-id="سایر"><span class="nn_tabs-toggle-inner">سایر</span></a>\r\n</li>\r\n</ul>\r\n<div class="tab-content">\r\n<div class="tab-pane nn_tabs-pane active" id="union">\r\n<h2 class="nn_tabs-title"><a name="union" class="anchor"></a>UNION</h2>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal; text-align: justify;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt;"><img src="http://union-instruments.com/images/logos/Union_Logo_130.png" alt="" width="130" height="122"></span></p>\r\n<p dir="RTL" style="margin-top: 0in; margin-right: 0in; margin-bottom: 0.0001pt; text-align: justify; line-height: 19.2pt; direction: rtl; unicode-bidi: embed;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt; color: #000000;">مصرف گاز طبیعی<span dir="LTR">Natural Gas</span>&nbsp;و یا گازهای سوختنی<span dir="LTR">&nbsp;GasesCombustible</span><span class="apple-converted-space"></span>بعنوان "سوخت " در صنعت کاربرد روز افزون یافته و بدلیل تاثیر ترکیب گاز<span dir="LTR">Gas Composition</span>&nbsp;و تاثیر آن بر فرآیند سوختن<span dir="LTR">Combustion Process</span>&nbsp;بحث اندازه گیری ترکیبات و میزان ارزش حرارتی مطرح می گردد. اندازه گیری ارزش حرارتی گاز چه در قالب ارزش حرارتی &nbsp;براساس<span dir="LTR">Calorific Value</span>&nbsp;یا<span dir="LTR">Wobbe index</span>&nbsp;در بسیاری از صنایع ارزشی روز افزون یافته است. این اندازه گیری بصورت آنلاین به روشهای مختلف صورت می پذیرد که یکی از آنها روش کالریمتریک &nbsp;می باشد. شرکت<span dir="LTR">UNION Instruments</span><span class="apple-converted-space"></span>آلمان با یکصد سال سابقه از پیشتازان ساخت آنالایزرهای آنلاین اندازه گیری ترکیبات گازی است.</span></p>\r\n<p dir="RTL" style="margin-top: 0in; margin-right: 0in; margin-bottom: 0.0001pt; text-align: justify; line-height: 19.2pt; direction: rtl; unicode-bidi: embed;"><span style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 10pt; color: #000000;">پیرامون سیستم قشم بعنوان شرکت تخصصی ارائه دهنده راهکارهای آنالایزر در ایران بعنوان نماینده شرکت<strong><span dir="LTR">UNION</span></strong>&nbsp;این افتخار را دارد که فعالیتهای مهندسی و تامین و خدمات پس از فروش این آنالایزرها را در<strong>ایران</strong>ارائه نماید.</span></p>\r\n<p dir="RTL" style="margin-top: 0in; margin-right: 0in; margin-bottom: 0.0001pt; text-align: justify; line-height: 19.2pt; direction: rtl; unicode-bidi: embed;"><span style="font-size: 10pt; font-family: Tahoma, sans-serif; color: black;">برای دریافت اطلاعات بیشتر خواهشمند است به تارنمای</span><span class="apple-converted-space"><span style="font-size: 10pt; font-family: Tahoma, sans-serif; color: black;"><span> (</span></span><span style="color: #0000ff;"><strong><span style="font-size: 10pt; font-family: Tahoma, sans-serif;"><a href="http://www.union-instruments.com/" style="color: #0000ff;"><span dir="LTR">http://union-instruments.com</span></a></span></strong></span></span><span class="apple-converted-space"><span style="font-size: 10pt; font-family: Tahoma, sans-serif; color: black;"><span>) </span></span><span style="font-size: 10pt; font-family: Tahoma, sans-serif; color: black;">سر زده یا ایمیل خود را به آدرس</span></span></p>\r\n<p dir="RTL" style="margin-top: 0in; margin-right: 0in; margin-bottom: 0.0001pt; text-align: justify; line-height: 19.2pt; direction: rtl; unicode-bidi: embed;"><span class="apple-converted-space"><span style="font-size: 10pt; font-family: Tahoma, sans-serif; color: black;"><span class="apple-converted-space"></span></span><strong><span><em><span dir="LTR" style="font-size: 10pt; font-family: Tahoma, sans-serif; color: blue;">info @piramoonco.com</span></em></span></strong></span><span class="apple-converted-space"><span style="font-size: 10pt; font-family: Tahoma, sans-serif; color: black;"></span></span></p>\r\n<p dir="RTL" style="margin-top: 0in; margin-right: 0in; margin-bottom: 0.0001pt; text-align: justify; line-height: 19.2pt; direction: rtl; unicode-bidi: embed;"><span class="apple-converted-space"><span style="font-size: 10pt; font-family: Tahoma, sans-serif; color: black;">یا</span></span></p>\r\n<p dir="RTL" style="margin-top: 0in; margin-right: 0in; margin-bottom: 0.0001pt; text-align: justify; line-height: 19.2pt; direction: rtl; unicode-bidi: embed;"><span style="color: black;"><em><strong><span dir="LTR" style="color: blue;"><span style="font-family: tahoma, arial, helvetica, sans-serif;">bernd.renner @union-instruments.com</span></span></strong></em></span></p>\r\n<p dir="RTL" style="margin-top: 0in; margin-right: 0in; margin-bottom: 0.0001pt; text-align: justify; line-height: 19.2pt; direction: rtl; unicode-bidi: embed;"><span class="apple-converted-space"><span style="font-size: 10pt; font-family: Tahoma, sans-serif; color: black;"></span><span style="font-size: 10pt; font-family: Tahoma, sans-serif; color: black;">ارسال&nbsp;فرمایید.</span>&nbsp;</span></p>\r\n<p dir="RTL" style="direction: rtl; unicode-bidi: embed; text-align: justify;">&nbsp;</p>\r\n\r\n\r\n</div>\r\n<div class="tab-pane nn_tabs-pane" id="سایر">\r\n<h2 class="nn_tabs-title"><a name="سایر" class="anchor"></a>سایر</h2>\r\n<p style="padding-top: 5px; padding-bottom: 5px; color: #000000; font-size: 11px; line-height: normal;">&amp;...</p>\r\n</div></div></div> 	</div>\r\n\r\n	\r\n							</div>', NULL, '2016-07-26 16:37:58', '1_1469534878950.jpg', 'Piramoon System Qeshm', 'Piramoon-System-Qeshm', 'Piramoon System Qeshm', 'پیرامون سیستم قشم', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_en` longtext COLLATE utf8_unicode_ci,
  `content_fa` longtext COLLATE utf8_unicode_ci,
  `created_at` datetime DEFAULT NULL,
  `link` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_brand_id` (`brand_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `content_en`, `content_fa`, `created_at`, `link`, `title_en`, `title_fa`, `updated_at`, `brand_id`) VALUES
(1, '<div style="text-align: right;">testtes</div>', 'test', '2016-07-26 12:08:38', 'test.com', 'test', 'test', NULL, 1),
(2, 'test 2', 'test 2', '2016-07-26 12:08:52', 'test 2', 'test 2', ' test 2', NULL, 2),
(3, 'test 3', 'test 3', '2016-07-26 12:09:08', 'tes 3', 'test 3', 'test 3', NULL, 3),
(4, 'test 4', 'test 4&nbsp;', '2016-07-26 12:09:28', 'test 4', 'tes t4', 'test 4', NULL, 4),
(5, 'test 5', 'test 5', '2016-07-26 12:09:50', 'test 5', 'test 5', 'test 5', NULL, 5),
(6, 'test 6', 'test 6', '2016-07-26 12:10:13', 'test 6', 'test 5', 'test 6', NULL, 1),
(7, 'test 7', 'test 7', '2016-07-26 12:10:29', 'test 7', 'test 7', 'test 7', NULL, 2),
(8, 'test 8', 'test 8', '2016-07-26 12:10:45', 'test 8', 'test 8', 'test 8', NULL, 3),
(9, 'test 9', 'test 9', '2016-07-26 12:11:00', 'test 9', 'test 9', 'test 9', NULL, 4),
(10, 'test 10test<span class="Apple-tab-span" style="white-space:pre">	</span>', 'test 10', '2016-07-26 12:11:24', 'test 10', 'test 10', 'test 10', NULL, 4),
(11, 'test 11', 'test 11', '2016-07-26 12:12:24', 'test 11', 'test 11', 'test 11', NULL, 5);

-- --------------------------------------------------------

--
-- Table structure for table `product_img`
--

CREATE TABLE IF NOT EXISTS `product_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `img` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_img_product_id` (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=11 ;

--
-- Dumping data for table `product_img`
--

INSERT INTO `product_img` (`id`, `alt`, `created_at`, `img`, `updated_at`, `product_id`) VALUES
(1, 'test', '2016-07-17 11:09:14', '1_1469518971475.jpg', '2016-07-26 12:12:51', 1),
(2, 'test', '2016-07-26 12:15:39', '1_1469519139226.jpg', NULL, 2),
(3, 'test 3', '2016-07-26 12:15:51', '1_1469519151624.jpg', NULL, 3),
(4, 'test', '2016-07-26 12:16:02', '1_1469519162114.jpg', NULL, 4),
(5, 'test', '2016-07-26 12:16:18', '1_1469519178177.jpg', NULL, 5),
(6, 'test 6', '2016-07-26 12:16:28', '1_1469519188454.jpg', NULL, 6),
(7, 'test 7', '2016-07-26 12:16:41', '1_1469519201429.jpg', NULL, 7),
(8, 'test', '2016-07-26 12:16:50', '1_1469519210827.jpg', NULL, 8),
(9, '', '2016-07-26 12:17:10', '1_1469519230686.jpg', NULL, 10),
(10, 'test', '2016-07-26 12:17:21', '1_1469519241461.jpg', NULL, 11);

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title_en` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content_en` longtext COLLATE utf8_unicode_ci,
  `content_fa` longtext COLLATE utf8_unicode_ci,
  `link` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `ctg_id` int(11) DEFAULT NULL,
  `points` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ctg_id` (`ctg_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=17 ;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id`, `title_en`, `title_fa`, `content_en`, `content_fa`, `link`, `created_at`, `updated_at`, `ctg_id`, `points`) VALUES
(1, 'test', 'test', 'test', 'test', 'test.com', '2016-07-08 00:00:00', NULL, 1, '35.706551648963575,51.41730308532715'),
(2, 'test', 'test', 'test', 'test', 'test.reedyy', '2016-07-26 00:00:00', '2016-07-27 00:00:00', 1, '35.70332378944258,51.39781951904297'),
(3, 'test2', 'test2', 'test2', 'tst2', 'tst2', NULL, NULL, 1, '35.70332378944258,51.39781951904297'),
(4, 'test', 'tesdfs', 'testdasfasdf', 'te', 'stasd', NULL, NULL, 1, '35.69634053686432 , 51.391639709472656'),
(5, 'tesad', '', 'asdsdfs', 'dfdsfgsdf', 'gsdfgsdf', NULL, NULL, 1, '35.69634053686432 , 51.391639709472656'),
(6, 'g', 'df', 'dfg', 'dfg', 'dfg', NULL, NULL, 1, '35.696632425544585,51.39181137084961'),
(7, 'dfg', 'dfg', 'dfsg', 'dsfg', 'dfg', NULL, NULL, 1, '35.696632425544585,51.39181137084961'),
(8, 'test', 'tes', 'test', 'test', 'test', NULL, NULL, 1, '35.69788709904831,51.3914680480957'),
(9, 'test', 'test', 'test', 'tet', 'test', NULL, NULL, 2, '35.69189236971253,51.39335632324219'),
(10, 'test', 'etst', 'test', 'test', 'etst', NULL, NULL, 2, '35.68631547276645,51.40399932861328'),
(11, 'test', 'test', 'test', 'test', 'test', NULL, NULL, 2, '35.68938281433764,51.36932373046875'),
(12, 'Test', 'test', 'test', 'test', 'test', NULL, NULL, 2, '27.842719083637075,53.4814453125'),
(13, 'test', 'test', 'test', 'test', 'test', NULL, NULL, 2, '36.95647639022989,59.501953125'),
(14, 'test', 'test', 'test', 'test', 'tes', NULL, NULL, 2, '31.145165974105844,54.755859375'),
(15, '', '', 'test', 'test', 'test', NULL, NULL, 2, '27.53506486393991,59.23828125'),
(16, 'PERSIAN GULF STAR OIL COMPANY', 'PERSIAN GULF STAR OIL COMPANY', 'Design, integration, component manufacturing, and supply of complete refinery analyzer packages, including 3 Gas Chromatograph, one set of (CGA)...', 'test', 'test', NULL, NULL, 1, '27.50214663043345,55.41787147521973');

-- --------------------------------------------------------

--
-- Table structure for table `project_category`
--

CREATE TABLE IF NOT EXISTS `project_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title_en` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `describtion_en` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `describtion_fa` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `project_category`
--

INSERT INTO `project_category` (`id`, `title_en`, `title_fa`, `describtion_en`, `describtion_fa`, `created_at`, `updated_at`) VALUES
(1, 'REFINERIES', 'پالایشگاه ها', '', '', NULL, NULL),
(2, 'PETROCHEMICALS', 'پتروشیمی ها', '', '', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `project_img`
--

CREATE TABLE IF NOT EXISTS `project_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alt` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `img` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `craeted_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=11 ;

--
-- Dumping data for table `project_img`
--

INSERT INTO `project_img` (`id`, `alt`, `img`, `project_id`, `craeted_at`, `updated_at`) VALUES
(1, 'test', '1_1469262643063.jpg', 2, '2016-07-05 00:00:00', NULL),
(2, 'test', '1_1469365248681.jpg', 7, NULL, NULL),
(3, 'test', '1_1469365281714.jpg', 5, NULL, NULL),
(4, 'test', '1_1469365683239.jpg', 8, NULL, NULL),
(8, 'test2', '1_1469448181695.jpg', 16, NULL, NULL),
(9, 'Test', '1_1469516260574.jpg', 16, NULL, NULL),
(10, 'test2', '1_1469516272967.jpg', 16, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `served_emerson`
--

CREATE TABLE IF NOT EXISTS `served_emerson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_en` longtext COLLATE utf8_unicode_ci,
  `content_fa` longtext COLLATE utf8_unicode_ci,
  `created_at` datetime DEFAULT NULL,
  `img` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `served_emerson`
--

INSERT INTO `served_emerson` (`id`, `content_en`, `content_fa`, `created_at`, `img`, `title_en`, `title_fa`, `updated_at`) VALUES
(2, 'test', 'test', '2016-07-20 15:17:57', '1_1469011677831.jpg', 'testt', 'test', NULL),
(3, 'test2t', 'test2', '2016-07-20 15:18:12', '1_1469011692152.jpg', 'test2', 'test2', NULL),
(4, 'test2', 'test3', '2016-07-20 15:18:29', '1_1469011709223.jpg', 'test3', 'test3', NULL),
(5, 'test 4', 'تست ۴', '2016-07-20 15:18:54', '1_1469011734642.jpg', 'test 4', 'تست ۴', NULL),
(6, 'test 5', 'تست ۵', '2016-07-20 15:19:20', '1_1469011760735.jpg', 'test 5', 'تست ۵', NULL),
(7, 'test 6', 'تست ۶', '2016-07-20 15:19:50', '1_1469011790487.jpg', 'test 6', 'تست ۶', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE IF NOT EXISTS `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content_en` longtext COLLATE utf8_unicode_ci,
  `content_fa` longtext COLLATE utf8_unicode_ci,
  `created_at` datetime DEFAULT NULL,
  `img` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `meta` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pdf` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `visit` int(11) DEFAULT NULL,
  `ctg_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_services_ctg_id` (`ctg_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `content_en`, `content_fa`, `created_at`, `img`, `meta`, `pdf`, `slug`, `title_en`, `title_fa`, `updated_at`, `visit`, `ctg_id`) VALUES
(12, '<h2>Operate at Your Peak Potential</h2><p>The rigorous demands of your process operations require you to have reliable, accurate devices <br/>that give you the measurements you need. Emerson delivers field-proven technologies that can <br/>handle the toughest conditions or analytical challenges to allow you to maximize the performance, <br/>profitability and, most importantly, safety of your applications.</p>', '<h2>کار در پتانسیل اوج خود</h2>\r\n<p>خواسته دقیق عملیات روند خود را نیاز شما را داشته قابل اعتماد، دستگاه های دقیق که شما در اندازه گیری های مورد نیاز را. امرسون ارائه فن آوری های میدان ثابت شده است که می توانید رسیدگی به سخت ترین شرایط و یا چالش های تحلیلی به شما اجازه می به حداکثر رساندن عملکرد،سودآوری و مهمتر از همه، ایمنی از برنامه های کاربردی خود را.</p>', '2016-07-20 12:38:45', '1_1469251146602.jpg', 'Measure & Analyze', '1_1469258067610.png', 'Measure-Analyze', 'Measure & Analyze', 'اندازه گیری و تجزیه و تحلیل', '2016-07-23 11:54:27', NULL, 2),
(13, '<h2 style="font-weight: normal; font-size: 28px; color: rgb(89, 88, 88); margin-bottom: 15px; margin-top: 6px; font-family: Arial; line-height: 20px; background-color: rgb(255, 255, 255);">Sharper insight into your assets</h2><p style="color: rgb(144, 144, 144); line-height: 19px; margin-bottom: 6px; font-size: 14px; font-family: Arial; background-color: rgb(255, 255, 255);">Predictive maintenance technology helps reduce costs, enhance asset performance, and<br>minimize downtime.</p>', '<h2>بینش واضح تر به دارایی های خود را</h2>\r\n\r\n<p>تکنولوژی تعمیر و نگهداری پیش بینی کمک می کند تا کاهش هزینه ها، افزایش عملکرد دارایی، و\r\nبه حداقل رساندن خرابی.</p>', '2016-07-20 12:42:48', '1_1469002368010.jpg', 'Operate & Manage', '1_1469258097078.png', 'Operate-Manage', 'Operate & Manage', 'کار و مدیریت', '2016-07-23 11:44:57', NULL, 2),
(14, '<h2 style="font-weight: normal; font-size: 28px; color: rgb(89, 88, 88); margin-bottom: 15px; margin-top: 6px; font-family: Arial; line-height: 20px; background-color: rgb(255, 255, 255);">Reliability you can count on</h2><p style="color: rgb(144, 144, 144); line-height: 19px; margin-bottom: 6px; font-size: 14px; font-family: Arial; background-color: rgb(255, 255, 255);">Smart technology helps you control maintenance costs while enhancing performance and life<br>expectancy of your emergency shutdown, on/off, or control valves.</p>', '<h2>قابلیت اطمینان شما می توانید بر روی تعداد</h2>\r\n\r\n<p>فن آوری هوشمند کمک می کند تا شما کنترل هزینه های نگهداری در حالی که افزایش عملکرد و عمر\r\nامید به خاموش کردن اضطراری خود را، روشن / خاموش، و یا دریچه های کنترل.</p>', '2016-07-20 12:44:52', '1_1469002492770.jpg', 'Final Control & Regulate', '1_1469258111943.png', 'Final-Control-Regulate', 'Final Control & Regulate', 'کنترل نهایی و تنظیم', '2016-07-23 11:45:11', NULL, 2),
(15, '<div class="techHeadline" style="font-family: arial, helvetica, sans-serif; font-weight: bold; font-size: 24px; color: rgb(89, 88, 88); background-color: rgb(255, 255, 255);">Learn about Solve &amp; Support</div><div class="pnlSpacerHrz" style="margin-top: 20px; color: rgb(103, 103, 103); font-family: arial, helvetica, sans-serif; font-size: 10.6667px; background-color: rgb(255, 255, 255);"></div><div class="techBody" style="font-family: arial, helvetica, sans-serif; font-size: 12px; color: rgb(89, 88, 88); background-color: rgb(255, 255, 255);">Emerson, with its global network of service capabilities, has been the partner of choice for many companies just like yours. Our consultants help clients envision and capture the value of innovative technologies and accelerate a sustainable competitive edge.&nbsp; With 5,000 Project Services engineers around the globe, we are able to provide both local and back-office support from plant concept to start-up. Once your plant is up and running, our 3,000 Lifecycle Services personnel at 400 services locations around the world can provide maintenance, reliability and performance services—where and when you need them. Our Educational Services, with more than 400 certified trainers in 43 countries, are available to fully train your staff at all stages of your plant life cycle.</div>', '<h2>اطلاعات در مورد حل و پشتیبانی</h2>\r\n<p>امرسون، با استفاده از شبکه جهانی خود را از قابلیت های سرویس، به شریک انتخابی برای بسیاری از شرکت های درست مثل مال شما بوده است. مشاوران ما کمک به مشتریان پیش بینی و تصرف ارزش فن آوری های نوین و سرعت بخشیدن به یک مزیت رقابتی پایدار است. با 5000 خدمات پروژه مهندسان در سراسر جهان، ما قادر به ارائه هر دو محلی و به عقب دفتر پشتیبانی از مفهوم گیاه به راه اندازی. هنگامی که کارخانه خود را به بالا و در حال اجرا، 3000 چرخه خدمات پرسنل ما در 400 خدمات مکان در سراسر جهان را تامین می کنند تعمیر و نگهداری، قابلیت اطمینان و عملکرد خدمات که در آن و زمانی که شما به آنها نیاز دارید. خدمات آموزشی ما، با بیش از 400 مربیان خبره در 43 کشور، در دسترس به طور کامل آموزش کارکنان خود را در تمام مراحل چرخه زندگی گیاه خود را می باشد.</p>', '2016-07-20 12:47:11', '1_1469002631606.jpg', 'Solve & Support', NULL, 'Solve-Support', 'Solve & Support', 'حل و پشتیبانی', NULL, NULL, 2);

-- --------------------------------------------------------

--
-- Table structure for table `services_category`
--

CREATE TABLE IF NOT EXISTS `services_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `describtion_en` varchar(4000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `describtion_fa` varchar(4000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `slug` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title_fa` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `services_category`
--

INSERT INTO `services_category` (`id`, `created_at`, `describtion_en`, `describtion_fa`, `slug`, `title_en`, `title_fa`, `updated_at`) VALUES
(2, '2016-07-20 11:54:21', '<h2>Cut through complexities to enrich your operations.</h2> Running a process operation means constant pressure to cut costs, increase output, reduce energy use and emissions, and \r\nimprove safety—all while managing increasingly complex operations. That’s why our customers around the world turn to us not only for automation technologies, but also for engineering services to help them plan, implement, and support their operations. With more than 7,500 industry experts around the world, we help solve the problems our customers face today and build an advantage for <h2>tomorrow.  Improved reliability can help industry recover $50 billion in lost production time</h2> With more than 25 years of leadership in developing reliability-enhancing technologies and services, Emerson’s expanded global reliability management consulting practice guides leaders on how to better manage maintenance costs, improve reliability, and increase profitability. ', '<h2><span style="font-family: Arial, Verdana; font-size: 13.3333px;">برش از طریق پیچیدگی به غنی سازی عملیات خود را.</span></h2><p><span style="font-family: Arial, Verdana; font-size: 13.3333px;"><br></span></p><p><span style="font-family: Arial, Verdana; font-size: 13.3333px;">در حال اجرا یک عملیات پردازش یعنی فشار ثابت به کاهش هزینه ها، افزایش خروجی، کاهش مصرف انرژی و انتشار، و بهبود ایمنی همه در حالی که مدیریت عملیات به طور فزاینده پیچیده. به همین دلیل مشتریان ما در سراسر جهان نوبه خود به ما نه تنها برای فن آوری اتوماسیون، بلکه همچنین برای خدمات مهندسی برای کمک به آنها برنامه ریزی، پیاده سازی، و حمایت از عملیات خود را. با بیش از 7500 کارشناسان صنعت در سراسر جهان، ما کمک به حل مشکلات مشتریان ما امروز با آن مواجه و ساخت یک مزیت برای</span></p><h2><span style="font-family: Arial, Verdana; font-size: 13.3333px;">فردا. قابلیت اطمینان بهبود یافته می تواند کمک به صنعت بازیابی 50 میلیارد $ در زمان تولید از دست رفته</span></h2><p><span style="font-family: Arial, Verdana; font-size: 13.3333px;"><br></span></p><p><span style="font-family: Arial, Verdana; font-size: 13.3333px;">با بیش از 25 سال از رهبری در حال توسعه فن آوری و خدمات قابلیت اطمینان افزایش، گسترش اعتماد جهانی عمل مشاوره مدیریت امرسون هدایت رهبران در مورد نحوه مدیریت بهتر هزینه های نگهداری، بهبود قابلیت اطمینان، و افزایش سودآوری است.</span></p>', 'Core-Offering', 'Core Offering', 'هسته کار', '2016-07-20 15:12:36');

-- --------------------------------------------------------

--
-- Table structure for table `services_category_img`
--

CREATE TABLE IF NOT EXISTS `services_category_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `img` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `services_category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_services_category_img_services_category_id` (`services_category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `services_category_img`
--

INSERT INTO `services_category_img` (`id`, `alt`, `created_at`, `img`, `updated_at`, `services_category_id`) VALUES
(1, 'test', '2016-07-17 11:36:27', '1_1468739224489.jpg', '2016-07-17 11:37:04', NULL),
(4, 'test', '2016-07-17 13:19:04', '1_1468745344238.jpg', NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `FK_news_ctg_id` FOREIGN KEY (`ctg_id`) REFERENCES `news_category` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK_product_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brand_emerson` (`id`);

--
-- Constraints for table `product_img`
--
ALTER TABLE `product_img`
  ADD CONSTRAINT `FK_product_img_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`ctg_id`) REFERENCES `project_category` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `project_img`
--
ALTER TABLE `project_img`
  ADD CONSTRAINT `project_img_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `FK_services_ctg_id` FOREIGN KEY (`ctg_id`) REFERENCES `services_category` (`id`);

--
-- Constraints for table `services_category_img`
--
ALTER TABLE `services_category_img`
  ADD CONSTRAINT `FK_services_category_img_services_category_id` FOREIGN KEY (`services_category_id`) REFERENCES `services_category` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
