/*
 *
 * Copyright 2017 PingCAP, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.spark.sql.expression.index

import org.apache.spark.sql.BaseInitialOnceTest

class PlaceHolder2Suite extends BaseInitialOnceTest {
  private val allCases = Seq[String](
    //"select tp_decimal from full_data_type_table_idx  where tp_decimal != null",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 'PingCAP'",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != '2017-11-02'",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 9223372036854775807",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != -9223372036854775808",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 1.7976931348623157E308",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 3.14159265358979",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 2.34E10",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 2147483647",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != -2147483648",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 32767",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != -32768",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 127",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != -128",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 0",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal != 2147868.65536",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> null",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 'PingCAP'",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> '2017-11-02'",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 9223372036854775807",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> -9223372036854775808",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 1.7976931348623157E308",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 3.14159265358979",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 2.34E10",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 2147483647",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> -2147483648",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 32767",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> -32768",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 127",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> -128",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 0",
    "select tp_tinyint from full_data_type_table_idx  where tp_tinyint <> 2147868.65536",
    "select tp_float from full_data_type_table_idx  where tp_float <> null",
    "select tp_float from full_data_type_table_idx  where tp_float <> 'PingCAP'",
    "select tp_float from full_data_type_table_idx  where tp_float <> '2017-11-02'",
    "select tp_float from full_data_type_table_idx  where tp_float <> 9223372036854775807",
    "select tp_float from full_data_type_table_idx  where tp_float <> -9223372036854775808",
    "select tp_float from full_data_type_table_idx  where tp_float <> 1.7976931348623157E308",
    "select tp_float from full_data_type_table_idx  where tp_float <> 3.14159265358979",
    "select tp_float from full_data_type_table_idx  where tp_float <> 2.34E10",
    "select tp_float from full_data_type_table_idx  where tp_float <> 2147483647",
    "select tp_float from full_data_type_table_idx  where tp_float <> -2147483648",
    "select tp_float from full_data_type_table_idx  where tp_float <> 32767",
    "select tp_float from full_data_type_table_idx  where tp_float <> -32768",
    "select tp_float from full_data_type_table_idx  where tp_float <> 127",
    "select tp_float from full_data_type_table_idx  where tp_float <> -128",
    "select tp_float from full_data_type_table_idx  where tp_float <> 0",
    "select tp_float from full_data_type_table_idx  where tp_float <> 2147868.65536",
    "select id_dt from full_data_type_table_idx  where id_dt <> null",
    "select id_dt from full_data_type_table_idx  where id_dt <> 'PingCAP'",
    "select id_dt from full_data_type_table_idx  where id_dt <> '2017-11-02'",
    "select id_dt from full_data_type_table_idx  where id_dt <> 9223372036854775807",
    "select id_dt from full_data_type_table_idx  where id_dt <> -9223372036854775808",
    "select id_dt from full_data_type_table_idx  where id_dt <> 1.7976931348623157E308",
    "select id_dt from full_data_type_table_idx  where id_dt <> 3.14159265358979",
    "select id_dt from full_data_type_table_idx  where id_dt <> 2.34E10",
    "select id_dt from full_data_type_table_idx  where id_dt <> 2147483647",
    "select id_dt from full_data_type_table_idx  where id_dt <> -2147483648",
    "select id_dt from full_data_type_table_idx  where id_dt <> 32767",
    "select id_dt from full_data_type_table_idx  where id_dt <> -32768",
    "select id_dt from full_data_type_table_idx  where id_dt <> 127",
    "select id_dt from full_data_type_table_idx  where id_dt <> -128",
    "select id_dt from full_data_type_table_idx  where id_dt <> 0",
    "select id_dt from full_data_type_table_idx  where id_dt <> 2147868.65536",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> null",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 'PingCAP'",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> '2017-11-02'",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 9223372036854775807",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> -9223372036854775808",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 1.7976931348623157E308",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 3.14159265358979",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 2.34E10",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 2147483647",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> -2147483648",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 32767",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> -32768",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 127",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> -128",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 0",
    "select tp_bigint from full_data_type_table_idx  where tp_bigint <> 2147868.65536",
    "select tp_double from full_data_type_table_idx  where tp_double <> null",
    "select tp_double from full_data_type_table_idx  where tp_double <> 'PingCAP'",
    "select tp_double from full_data_type_table_idx  where tp_double <> '2017-11-02'",
    "select tp_double from full_data_type_table_idx  where tp_double <> 9223372036854775807",
    "select tp_double from full_data_type_table_idx  where tp_double <> -9223372036854775808",
    "select tp_double from full_data_type_table_idx  where tp_double <> 1.7976931348623157E308",
    "select tp_double from full_data_type_table_idx  where tp_double <> 3.14159265358979",
    "select tp_double from full_data_type_table_idx  where tp_double <> 2.34E10",
    "select tp_double from full_data_type_table_idx  where tp_double <> 2147483647",
    "select tp_double from full_data_type_table_idx  where tp_double <> -2147483648",
    "select tp_double from full_data_type_table_idx  where tp_double <> 32767",
    "select tp_double from full_data_type_table_idx  where tp_double <> -32768",
    "select tp_double from full_data_type_table_idx  where tp_double <> 127",
    "select tp_double from full_data_type_table_idx  where tp_double <> -128",
    "select tp_double from full_data_type_table_idx  where tp_double <> 0",
    "select tp_double from full_data_type_table_idx  where tp_double <> 2147868.65536",
    "select tp_datetime from full_data_type_table_idx  where tp_datetime <> null",
    "select tp_datetime from full_data_type_table_idx  where tp_datetime <> 'PingCAP'",
    "select tp_datetime from full_data_type_table_idx  where tp_datetime <> '2017-11-02'",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> null",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 'PingCAP'",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> '2017-11-02'",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 9223372036854775807",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> -9223372036854775808",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 1.7976931348623157E308",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 3.14159265358979",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 2.34E10",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 2147483647",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> -2147483648",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 32767",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> -32768",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 127",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> -128",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 0",
    "select tp_smallint from full_data_type_table_idx  where tp_smallint <> 2147868.65536",
    "select tp_date from full_data_type_table_idx  where tp_date <> null",
    "select tp_date from full_data_type_table_idx  where tp_date <> 'PingCAP'",
    "select tp_date from full_data_type_table_idx  where tp_date <> '2017-11-02'",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> null",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 'PingCAP'",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> '2017-11-02'",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 9223372036854775807",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> -9223372036854775808",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 1.7976931348623157E308",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 3.14159265358979",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 2.34E10",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 2147483647",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> -2147483648",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 32767",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> -32768",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 127",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> -128",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 0",
    "select tp_mediumint from full_data_type_table_idx  where tp_mediumint <> 2147868.65536",
    "select tp_int from full_data_type_table_idx  where tp_int <> null",
    "select tp_int from full_data_type_table_idx  where tp_int <> 'PingCAP'",
    "select tp_int from full_data_type_table_idx  where tp_int <> '2017-11-02'",
    "select tp_int from full_data_type_table_idx  where tp_int <> 9223372036854775807",
    "select tp_int from full_data_type_table_idx  where tp_int <> -9223372036854775808",
    "select tp_int from full_data_type_table_idx  where tp_int <> 1.7976931348623157E308",
    "select tp_int from full_data_type_table_idx  where tp_int <> 3.14159265358979",
    "select tp_int from full_data_type_table_idx  where tp_int <> 2.34E10",
    "select tp_int from full_data_type_table_idx  where tp_int <> 2147483647",
    "select tp_int from full_data_type_table_idx  where tp_int <> -2147483648",
    "select tp_int from full_data_type_table_idx  where tp_int <> 32767",
    "select tp_int from full_data_type_table_idx  where tp_int <> -32768",
    "select tp_int from full_data_type_table_idx  where tp_int <> 127",
    "select tp_int from full_data_type_table_idx  where tp_int <> -128",
    "select tp_int from full_data_type_table_idx  where tp_int <> 0",
    "select tp_int from full_data_type_table_idx  where tp_int <> 2147868.65536",
    "select tp_timestamp from full_data_type_table_idx  where tp_timestamp <> null",
    "select tp_timestamp from full_data_type_table_idx  where tp_timestamp <> 'PingCAP'",
    "select tp_timestamp from full_data_type_table_idx  where tp_timestamp <> '2017-11-02'",
    "select tp_real from full_data_type_table_idx  where tp_real <> null",
    "select tp_real from full_data_type_table_idx  where tp_real <> 'PingCAP'",
    "select tp_real from full_data_type_table_idx  where tp_real <> '2017-11-02'",
    "select tp_real from full_data_type_table_idx  where tp_real <> 9223372036854775807",
    "select tp_real from full_data_type_table_idx  where tp_real <> -9223372036854775808",
    "select tp_real from full_data_type_table_idx  where tp_real <> 1.7976931348623157E308",
    "select tp_real from full_data_type_table_idx  where tp_real <> 3.14159265358979",
    "select tp_real from full_data_type_table_idx  where tp_real <> 2.34E10",
    "select tp_real from full_data_type_table_idx  where tp_real <> 2147483647",
    "select tp_real from full_data_type_table_idx  where tp_real <> -2147483648",
    "select tp_real from full_data_type_table_idx  where tp_real <> 32767",
    "select tp_real from full_data_type_table_idx  where tp_real <> -32768",
    "select tp_real from full_data_type_table_idx  where tp_real <> 127",
    "select tp_real from full_data_type_table_idx  where tp_real <> -128",
    "select tp_real from full_data_type_table_idx  where tp_real <> 0",
    "select tp_real from full_data_type_table_idx  where tp_real <> 2147868.65536",
    // "select tp_decimal from full_data_type_table_idx  where tp_decimal <> null",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 'PingCAP'",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> '2017-11-02'",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 9223372036854775807",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> -9223372036854775808",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 1.7976931348623157E308",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 3.14159265358979",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 2.34E10",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 2147483647",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> -2147483648",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 32767",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> -32768",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 127",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> -128",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 0",
    "select tp_decimal from full_data_type_table_idx  where tp_decimal <> 2147868.65536"
  )

  allCases foreach { query =>
    {
      test(query) {
        runTest(query)
      }
    }
  }

}
