-- ----------------------------
-- Records of question
-- ----------------------------
BEGIN;

REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (2, '', '', 1645513218626, 1645513218626, 2, 0, 0, 0, '');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (3, 'asd', 'das', 1645513234102, 1645513234102, 3, 0, 0, 0, 'das,as');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (4, 'das', 'asd', 1645513810889, 1645513810889, 4, 0, 0, 0, 'sa,dsf');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (5, 'dasd', 'das', 1645515558210, 1645515558210, 5, 0, 0, 0, 'sa,dsf');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (6, 'das', 'afsfafas', 1645582684019, 1645582684019, 6, 0, 0, 0, 'fast');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (7, '1', '1', 1645595527881, 1645595527881, 1, 1, 1, 3, '1');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (8, '2', '2', 1645595527882, 1645595527882, 2, 2, 2, 3, '1');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (9, '3', '3', 1645595527883, 1645595527883, 3, 3, 3, 3, '1');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (10, '4', '4', 1645595527884, 1645595527884, 4, 4, 4, 3, '1');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (11, '5', '5', 1745595527771, 1745595527885, 5, 5, 5, 3, '1');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (12, '6', '6', 1845595527441, 1845595527886, 6, 6, 6, 3, '1');
REPLACE INTO community.question (id, title, description, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, tag) VALUES (13, '7', '7', 1845595527444, 1845595527887, 1, 7, 7, 3, '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Another usage of update
-- ----------------------------
# UPDATE community.question SET title = 'dasd', description = 'dasdsa', gmt_create = 1645511071553, gmt_modified = 1645511071553, creator = 1, comment_count = 0, view_count = 0, like_count = 0, tag = 'sa,dsf' WHERE id = 1;
# UPDATE community.question SET title = '', description = '', gmt_create = 1645513218626, gmt_modified = 1645513218626, creator = 1, comment_count = 0, view_count = 0, like_count = 0, tag = '' WHERE id = 2;
# UPDATE community.question SET title = 'asd', description = 'das', gmt_create = 1645513234102, gmt_modified = 1645513234102, creator = 1, comment_count = 0, view_count = 0, like_count = 0, tag = 'das,as' WHERE id = 3;
# UPDATE community.question SET title = 'das', description = 'asd', gmt_create = 1645513810889, gmt_modified = 1645513810889, creator = 1, comment_count = 0, view_count = 0, like_count = 0, tag = 'sa,dsf' WHERE id = 4;
# UPDATE community.question SET title = 'dasd', description = 'das', gmt_create = 1645515558210, gmt_modified = 1645515558210, creator = 1, comment_count = 0, view_count = 0, like_count = 0, tag = 'sa,dsf' WHERE id = 5;
# UPDATE community.question SET title = 'das', description = 'afsfafas', gmt_create = 1645582684019, gmt_modified = 1645582684019, creator = 1, comment_count = 0, view_count = 0, like_count = 0, tag = 'fast' WHERE id = 6;
# UPDATE community.question SET title = '1', description = '1', gmt_create = 1645595527881, gmt_modified = 1645595527881, creator = 1, comment_count = 1, view_count = 1, like_count = 3, tag = '1' WHERE id = 7;
# UPDATE community.question SET title = '2', description = '2', gmt_create = 1645595527882, gmt_modified = 1645595527882, creator = 1, comment_count = 2, view_count = 2, like_count = 3, tag = '1' WHERE id = 8;
# UPDATE community.question SET title = '3', description = '3', gmt_create = 1645595527883, gmt_modified = 1645595527883, creator = 1, comment_count = 3, view_count = 3, like_count = 3, tag = '1' WHERE id = 9;
# UPDATE community.question SET title = '4', description = '4', gmt_create = 1645595527884, gmt_modified = 1645595527884, creator = 1, comment_count = 4, view_count = 4, like_count = 3, tag = '1' WHERE id = 10;
# UPDATE community.question SET title = '5', description = '5', gmt_create = 1745595527771, gmt_modified = 1745595527885, creator = 1, comment_count = 5, view_count = 5, like_count = 3, tag = '1' WHERE id = 11;
# UPDATE community.question SET title = '6', description = '6', gmt_create = 1845595527441, gmt_modified = 1845595527886, creator = 1, comment_count = 6, view_count = 6, like_count = 3, tag = '1' WHERE id = 12;
# UPDATE community.question SET title = '7', description = '7', gmt_create = 1845595527444, gmt_modified = 1845595527887, creator = 1, comment_count = 7, view_count = 7, like_count = 3, tag = '1' WHERE id = 13;
